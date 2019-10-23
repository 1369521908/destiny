package com.gz.destinylegends.controller.lol.item;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gz.destinylegends.controller.base.BaseController;
import com.gz.destinylegends.entity.Item;
import com.gz.destinylegends.mapper.ItemMapper;
import com.gz.destinylegends.mapper.ItemPatchMapper;
import com.gz.destinylegends.dto.ItemPatch;
import com.gz.destinylegends.util.api.ApiUtil;
import com.gz.destinylegends.util.worn.WornUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author Destiny_Xue
 * @Date 2019/10/4 15:01
 * @Description 物品/装备 https://game.gtimg.cn/images/lol/act/img/js/items/items.js
 */
@RestController
@RequestMapping("lol/item")
@Transactional(rollbackFor = Exception.class)
public class ItemController extends BaseController {

    @Autowired
    private ItemPatchMapper itemPatchMapper;

    @Autowired
    private ItemMapper itemMapper;

    @GetMapping("worn")
    public Object worn(String url) {

        // 删除旧数据
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("1", 1);

        itemMapper.delete(wrapper);
        itemPatchMapper.delete(wrapper);

        String worn = WornUtil.worn(url);
        ItemPatch patch = JSONObject.toJavaObject(JSONObject.parseObject(worn), ItemPatch.class);
        patch.setTreeList(JSONObject.toJSONString(patch.getTree()));
        patch.setItemList(JSONObject.toJSONString(patch.getItems()));
        patch.setRecodeTime(DateUtil.beginOfDay(new Date()));
        itemPatchMapper.insert(patch);

        for (Item item : patch.getItems()) {
            item.setIntoList(JSONObject.toJSONString(item.getInto()));
            item.setMapList(JSONObject.toJSONString(item.getMaps()));
            item.setTypeList(JSONObject.toJSONString(item.getTypes()));
            item.setFromItems(JSONObject.toJSONString(item.getFrom()));
            itemMapper.insert(item);
        }
        return ApiUtil.success(patch);
    }
}
