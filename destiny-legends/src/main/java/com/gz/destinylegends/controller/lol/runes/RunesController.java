package com.gz.destinylegends.controller.lol.runes;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.gz.destinylegends.controller.base.BaseController;
import com.gz.destinylegends.entity.Runes;
import com.gz.destinylegends.mapper.RunesMapper;
import com.gz.destinylegends.mapper.RunesPatchMapper;
import com.gz.destinylegends.dto.RunesPatch;
import com.gz.destinylegends.util.api.ApiUtil;
import com.gz.destinylegends.util.worn.WornUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author Destiny_Xue
 * @Date 2019/10/4 16:05
 * @Description 符文数据 https://lol.qq.com/act/a20170926preseason/data/cn/runes.json
 */
@RestController
@RequestMapping("lol/runes")
public class RunesController extends BaseController {

    @Autowired
    private RunesMapper runesMapper;

    @Autowired
    private RunesPatchMapper runesPatchMapper;

    @GetMapping("worn")
    public Object worn(String url) {

        String worn = WornUtil.worn(url);
        RunesPatch patch = JSONObject.toJavaObject(JSONObject.parseObject(worn), RunesPatch.class);

        patch.setStyleList(JSONObject.toJSONString(patch.getStyles()));
        patch.setRecodeTime(DateUtil.beginOfDay(new Date()));
        runesPatchMapper.insert(patch);

        for (Runes runes : patch.getStyles()) {
            runes.setBonusesList(JSONObject.toJSONString(runes.getBonuses()));
            runes.setSlotList(runes.getSlots().toJSONString());
            runesMapper.insert(runes);
        }

        return ApiUtil.success(patch);
    }
}
