package com.gz.destinylegends.controller.lol.hero;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gz.destinylegends.entity.HeroDetail;
import com.gz.destinylegends.mapper.HeroDetailMapper;
import com.gz.destinylegends.util.api.ApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Destiny_Xue
 * @Date 2019/9/11 22:50
 * @Description
 */
@RestController
@RequestMapping("lol/heroDetail")
public class HeroDetailController {

    @Autowired
    private HeroDetailMapper heroDetailMapper;

    /**
     * 新增或编辑
     */
    @Cacheable(value = "heroDetail")
    @PostMapping
    public Object save(HeroDetail heroDetail) {
        HeroDetail heroDetail1 = heroDetailMapper.selectOne(new QueryWrapper<HeroDetail>().eq("id", heroDetail.getId()));
        if (heroDetail1 != null) {
            heroDetailMapper.updateById(heroDetail);
        } else {
            heroDetailMapper.insert(heroDetail);
        }
        return ApiUtil.success(heroDetail);
    }

    /**
     * 删除
     */
    @CacheEvict(value = "id")
    @DeleteMapping("/{id}")
    public Object delete(@PathVariable Long id) {
        HeroDetail heroDetail = heroDetailMapper.selectOne(new QueryWrapper<HeroDetail>().eq("id", id));
        if (heroDetail != null) {
            heroDetailMapper.delete(new QueryWrapper<HeroDetail>().eq("id", id));
            return ApiUtil.success(heroDetail);
        } else {
            return ApiUtil.notSearch();
        }
    }

    /**
     * 查询
     */
    @Cacheable(value = "id")
    @GetMapping("/{id}")
    public Object find(@PathVariable Long id) {
        HeroDetail heroDetail = heroDetailMapper.selectOne(new QueryWrapper<HeroDetail>().eq("id", id));
        if (heroDetail != null) {
            return ApiUtil.success(heroDetail);
        } else {
            return ApiUtil.notSearch();
        }
    }

    /**
     * 分页查询
     */
    @Cacheable(value = "list")
    @GetMapping
    public Object list(HeroDetail heroDetail,
                       @RequestParam(required = false, defaultValue = "0") int pageNumber,
                       @RequestParam(required = false, defaultValue = "10") int pageSize) {
        //分页构造器
        Page<HeroDetail> page = new Page<HeroDetail>(pageNumber, pageSize);
        //条件构造器
        QueryWrapper<HeroDetail> queryWrapper = new QueryWrapper<HeroDetail>(heroDetail);
        //执行分页
        IPage<HeroDetail> pageList = heroDetailMapper.selectPage(page, queryWrapper);
        //返回结果
        return ApiUtil.success(pageList);
    }

}
