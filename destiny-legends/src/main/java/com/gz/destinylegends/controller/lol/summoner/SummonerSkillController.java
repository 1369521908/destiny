package com.gz.destinylegends.controller.lol.summoner;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gz.destinylegends.controller.base.BaseController;
import com.gz.destinylegends.entity.SummonerSkill;
import com.gz.destinylegends.mapper.SummonerSkillMapper;
import com.gz.destinylegends.mapper.SummonerSkillPatchMapper;
import com.gz.destinylegends.dto.SummonerSkillPatch;
import com.gz.destinylegends.util.api.ApiUtil;
import com.gz.destinylegends.util.worn.WornUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Set;

/**
 * @Author Destiny_Xue
 * @Date 2019/10/3 22:31
 * @Description
 */
@RestController
@RequestMapping("lol/summonerSkill")
@Transactional(rollbackFor = Exception.class)
public class SummonerSkillController extends BaseController {

    @Autowired
    private SummonerSkillMapper summonerSkillMapper;

    @Autowired
    private SummonerSkillPatchMapper summonerSkillPatchMapper;

    /**
     * 爬取召唤师技能数据
     * 图标示例 https://ossweb-img.qq.com/images/lol/img/spell/SummonerBarrier.png
     *
     * @param url 官方数据接口 https://lol.qq.com/biz/hero/summoner.js
     * @return 结果
     */
    @GetMapping("worn")
    public Object worn(String url) {

        // 删除旧数据
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("1", 1);
        summonerSkillMapper.delete(wrapper);
        summonerSkillPatchMapper.delete(wrapper);

        String worn = WornUtil.worn(url);
        int length = worn.split("\\{")[0].length();
        // {SummonerSkillPatch}
        worn = worn.substring(length, worn.length() - 1);
        JSONObject jsonObject = JSONObject.parseObject(worn);

        // {SummonerSkillList}
        JSONObject data = jsonObject.getJSONObject("data");

        SummonerSkillPatch skillPatch = new SummonerSkillPatch();
        skillPatch.setVersion(jsonObject.getString("version"));
        skillPatch.setUpdated(jsonObject.getDate("updated"));

        Set<String> skillNameSet = data.keySet();
        for (String name : skillNameSet) {
            SummonerSkill summonerSkill = data.getJSONObject(name).toJavaObject(SummonerSkill.class);
            // 转换成全路径文件
            summonerSkill.getImage().replace("full",
                    "https://ossweb-img.qq.com/images/lol/img/spell/" + summonerSkill.getId() + ".png");
            summonerSkill.setImg(JSONObject.toJSONString(summonerSkill.getImage()));
            summonerSkill.setSkillKey(summonerSkill.getKey());
            summonerSkillMapper.insert(summonerSkill);
            skillPatch.getSkills().add(summonerSkill);
        }
        skillPatch.setSkillList(JSONObject.toJSONString(skillPatch.getSkills()));
        skillPatch.setRecodeTime(DateUtil.beginOfDay(new Date()));
        summonerSkillPatchMapper.insert(skillPatch);
        return ApiUtil.success(skillPatch);
    }
}
