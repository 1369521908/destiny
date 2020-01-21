package com.gz.destinylegends.controller.lol.hero;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gz.destinylegends.entity.HeroSpell;
import com.gz.destinylegends.mapper.HeroSpellMapper;
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
@RequestMapping("lol/heroSpell")
public class HeroSpellController {

    @Autowired
    private HeroSpellMapper heroSpellMapper;

    @Cacheable(value = "heroId")
    @GetMapping("/{heroId}")
    public Object find(@PathVariable Long heroId) {
        List<HeroSpell> heroSpells = heroSpellMapper.selectList(new QueryWrapper<HeroSpell>().eq("heroId", heroId));
        return ApiUtil.success(heroSpells);
    }

}
