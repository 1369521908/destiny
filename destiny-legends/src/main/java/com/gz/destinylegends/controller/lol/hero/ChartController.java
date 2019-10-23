package com.gz.destinylegends.controller.lol.hero;

import com.gz.destinylegends.manager.HeroDetailManager;
import com.gz.destinylegends.mapper.HeroDetailMapper;
import com.gz.destinylegends.util.api.ApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 英雄分析图表
 * @Author by xueqichang
 * @Email 1369521908@qq.com
 * @Date 2019/9/28 14:00
 */
@RestController
@RequestMapping("lol/chart")
public class ChartController {

    @Autowired
    private HeroDetailMapper heroDetailMapper;

    @Autowired
    private HeroDetailManager heroDetailManager;

    /**
     * 英雄属性六芒星(基础属性和战斗属性)
     *
     * @param id 英雄id
     * @return 数据结果
     */
    @PostMapping("hexagram")
    public Object hexagram(Long id) {
        return ApiUtil.success(heroDetailManager.hexagram(id));
    }

}
