package com.gz.destinylegends.controller.lol.hero;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gz.destinylegends.entity.HeroSkin;
import com.gz.destinylegends.mapper.HeroSkinMapper;
import com.gz.destinylegends.util.api.ApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Destiny_Xue
 * @Date 2020/1/1 23:39
 * @Description
 */
@RestController
@RequestMapping("lol/heroSkin")
public class HeroSkinController {

    @Autowired
    private HeroSkinMapper heroSkinMapper;

    @Cacheable(value = "heroId")
    @GetMapping("/{heroId}")
    public Object find(@PathVariable Long heroId) {
        List<HeroSkin> heroSpells = heroSkinMapper.selectList(new QueryWrapper<HeroSkin>().eq("heroId", heroId));
        return ApiUtil.success(heroSpells);
    }

}
