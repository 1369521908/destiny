package com.gz.destinylegends.util.api;

import com.alibaba.fastjson.JSONObject;
import com.gz.destinylegends.constant.Constant;

/**
 * @author Destiny_Xue
 */
public class ApiUtil extends JSONObject {

    private static final long serialVersionUID = 1L;

    public static JSONObject success() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.CODE, Constant.CODE_SUCCESS);
        jsonObject.put(Constant.MESSAGE, Constant.SUCCESS);
        return jsonObject;
    }

    public static JSONObject success(Object object) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.CODE, Constant.CODE_SUCCESS);
        jsonObject.put(Constant.DATA, object);
        jsonObject.put(Constant.MESSAGE, Constant.SUCCESS);
        return jsonObject;
    }

    public static JSONObject success(Object object, Object header) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.CODE, Constant.CODE_SUCCESS);
        jsonObject.put(Constant.DATA, object);
        jsonObject.put(Constant.MESSAGE, Constant.SUCCESS);
        jsonObject.put(Constant.HEADER, header);
        return jsonObject;
    }

    public static JSONObject error() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.CODE, Constant.CODE_ERROR);
        jsonObject.put(Constant.MESSAGE, Constant.ERROR);
        return jsonObject;
    }

    public static JSONObject notSearch() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.CODE, Constant.CODE_NOT_SEARCH);
        jsonObject.put(Constant.MESSAGE, Constant.NOT_SEARCH);
        jsonObject.put(Constant.DATA, null);
        return jsonObject;
    }

    public static JSONObject error(Object object) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.CODE, Constant.CODE_ERROR);
        jsonObject.put(Constant.MESSAGE, Constant.ERROR);
        jsonObject.put(Constant.DATA, object);
        return jsonObject;
    }

    public static JSONObject login(Boolean loginSuccess) {
        JSONObject jsonObject = new JSONObject();
        if (loginSuccess) {
            //临时token
            jsonObject.put(Constant.TOKEN, "admin-token");
            return success(jsonObject);
        } else {
            return error();
        }
    }
}
