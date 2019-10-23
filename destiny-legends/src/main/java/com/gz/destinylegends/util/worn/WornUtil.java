package com.gz.destinylegends.util.worn;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;

/**
 * @Author Destiny_Xue
 * @Date 2019/10/4 17:22
 * @Description
 */
public class WornUtil {

    public static String worn(String url) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("xxxxx", System.currentTimeMillis() * Math.random());
        jsonObject.put("yyyyy", System.currentTimeMillis() * Math.random());
        return HttpUtil.get(url, jsonObject);
    }
}
