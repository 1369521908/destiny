package com.gz.destinylegends.util.header;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.gz.destinylegends.util.header.Header;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Destiny_Xue
 * @Date 2019/9/10 22:35
 * @Description
 */
public class AvueHeader implements Header {

    /**
     * 根据cls 创建Avue控件的表头,参考:https://avuejs.com/doc/crud/crud-bigcousin
     * @param cls 目标类
     * @return 表头
     */
    public static String build(Class cls) {
        String s = "";
        s = JSONArray.toJSONString(cls.getDeclaredFields());
        List<JSONObject> jsonObjects = JSONObject.parseArray(s, JSONObject.class);
        List<JSONObject> fields = new ArrayList<>();
        for (JSONObject jsonObject : jsonObjects) {
            // TODO 判断类型是否添加为表头
            String fieldName = jsonObject.getString("name");
            JSONObject field = new JSONObject();
            field.put("prop", fieldName);
            field.put("label", fieldName);
            field.put("sortable", true);
            fields.add(field);
        }
        return JSONObject.toJSONString(fields);
    }
}
