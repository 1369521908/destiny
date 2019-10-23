package com.gz.destinylegends.controller.lol.hero;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.thread.ThreadUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gz.destinylegends.config.shiro.ShiroPermission;
import com.gz.destinylegends.controller.base.BaseController;
import com.gz.destinylegends.entity.Hero;
import com.gz.destinylegends.entity.HeroDetail;
import com.gz.destinylegends.entity.HeroSkin;
import com.gz.destinylegends.entity.HeroSpell;
import com.gz.destinylegends.mapper.*;
import com.gz.destinylegends.dto.HeroPatch;
import com.gz.destinylegends.util.api.ApiUtil;
import com.gz.destinylegends.util.worn.WornUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;

/**
 * @Author Destiny_Xue
 * @Date 2019/9/11 22:50
 * @Description
 */
@Slf4j
@RestController
@RequestMapping("lol/hero")
@Transactional(rollbackFor = Exception.class)
public class HeroController extends BaseController {

    @Autowired
    private HeroMapper heroMapper;

    @Autowired
    private HeroDetailMapper heroDetailMapper;

    @Autowired
    private HeroSkinMapper heroSkinMapper;

    @Autowired
    private HeroSpellMapper heroSpellMapper;

    @Autowired
    private HeroPatchMapper heroPatchMapper;

    /**
     * 新增或编辑
     */
    @Cacheable(value = "hero")
    @PostMapping
    public Object save(Hero hero) {
        Hero hero1 = heroMapper.selectOne(new QueryWrapper<Hero>().eq("id", hero.getId()));
        if (hero1 != null) {
            heroMapper.updateById(hero);
        } else {
            heroMapper.insert(hero);
        }
        return ApiUtil.success(hero);
    }

    /**
     * 删除
     */
    @CacheEvict(value = "id")
    @DeleteMapping("/{id}")
    public Object delete(@PathVariable Long id) {
        Hero hero = heroMapper.selectOne(new QueryWrapper<Hero>().eq("id", id));
        if (hero != null) {
            return ApiUtil.success(hero);
        } else {
            return ApiUtil.error();
        }
    }

    /**
     * 查询
     */
    @Cacheable(value = "id")
    @GetMapping("/{id}")
    public Object find(@PathVariable Long id) {
        Hero hero = heroMapper.selectOne(new QueryWrapper<Hero>().eq("id", id));
        if (hero != null) {
            return ApiUtil.success(hero);
        } else {
            return ApiUtil.notSearch();
        }
    }

    /**
     * 分页查询
     */
    @Cacheable(value = "list")
    @GetMapping
    public Object list(Hero hero,
                       @RequestParam(required = false, defaultValue = "0") Long currentPage,
                       @RequestParam(required = false, defaultValue = "10") Long pageSize) {
        //分页构造器
        Page<Hero> page = new Page<Hero>(currentPage, pageSize);
        //条件构造器
        QueryWrapper<Hero> queryWrapper = new QueryWrapper<Hero>(hero);
        //执行分页
        IPage<Hero> pageList = heroMapper.selectPage(page, queryWrapper);
        //返回结果
        return ApiUtil.success(pageList);
    }

    /**
     * 爬取数据
     * 英雄简单信息列表: https://game.gtimg.cn/images/lol/act/img/js/heroList/hero_list.js
     * 英雄明细(简介): https://lol.qq.com/biz/hero/Annie.js
     * 更详细的信息(详细属性): https://game.gtimg.cn/images/lol/act/img/js/hero/1.js
     *
     * @param url       url https://game.gtimg.cn/images/lol/act/img/js/heroList/hero_list.js
     * @param urlDetail 详细url https://game.gtimg.cn/images/lol/act/img/js/hero/
     * @return 结果
     */
    @GetMapping("worn")
    @RequiresPermissions(value = ShiroPermission.HERO_WORN)
    public Object worn(String url, String urlDetail) {
        long start = System.currentTimeMillis();
        final String heroKey = "hero";
        log.info("开始爬取数据:{}", start);
        String worn = WornUtil.worn(url);
        JSONObject jsonObject = JSONObject.parseObject(worn);
        //删除旧数据
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("1", 1);
        heroMapper.delete(wrapper);
        heroDetailMapper.delete(wrapper);
        heroSkinMapper.delete(wrapper);
        heroSpellMapper.delete(wrapper);
        heroPatchMapper.delete(wrapper);

        for (Object o : jsonObject.getJSONArray(heroKey)) {
            ThreadUtil.execute(() -> {
                Hero hero = JSONObject.parseObject(JSONObject.toJSONString(o), Hero.class);
                hero.setAvatar("https://game.gtimg.cn/images/lol/act/img/champion/" + hero.getAlias() + ".png");
                hero.setRole(Arrays.toString(hero.getRoles().toArray()));
                hero.setId(hero.getHeroId());
                heroMapper.insert(hero);
                String detail = getDetail(urlDetail, hero);
                HeroPatch heroPatch = JSONObject.toJavaObject((JSON) JSON.parse(detail), HeroPatch.class);
                heroPatch.setFileName("https://game.gtimg.cn/images/lol/act/img/js/hero/" + heroPatch.getFileName());
                heroPatch.setHeroInfo(JSONObject.toJSONString(heroPatch.getHero()));
                heroPatch.setSkinList(JSONObject.toJSONString(heroPatch.getSkins()));
                heroPatch.setSpellList(JSONObject.toJSONString(heroPatch.getSpells()));
                heroPatch.setRecodeTime(DateUtil.beginOfDay(new Date()));
                heroPatchMapper.insert(heroPatch);
                HeroDetail heroDetail = new HeroDetail();
                heroDetail = heroPatch.getHero();
                heroDetail.setId(heroDetail.getHeroId());
                heroDetail.setRole(Arrays.toString(heroDetail.getRoles().toArray()));
                heroDetailMapper.insert(heroDetail);

                for (HeroSkin skin : heroPatch.getSkins()) {
                    heroSkinMapper.insert(skin);
                }

                for (HeroSpell heroSpell : heroPatch.getSpells()) {
                    heroSpellMapper.insert(heroSpell);
                }
            });
        }
        log.info("数据保存完毕,耗时:{}", System.currentTimeMillis() - start);
        return ApiUtil.success(jsonObject);
    }

    private String getDetail(String urlDetail, Hero hero) {
        try {
            return WornUtil.worn(urlDetail + hero.getHeroId() + ".js");
        } catch (Exception e) {
            return getDetail(urlDetail, hero);
        }
    }

}
