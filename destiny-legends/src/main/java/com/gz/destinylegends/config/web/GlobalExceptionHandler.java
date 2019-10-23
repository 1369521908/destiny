package com.gz.destinylegends.config.web;

import com.alibaba.fastjson.JSONObject;
import com.gz.destinylegends.util.api.ApiUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description 全局异常处理
 * @Author by xueqichang
 * @Email 1369521908@qq.com
 * @Date 2019/9/28 11:51
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final String TAG = "GlobalExceptionHandler.{}";

    /**
     * 全局异常处理
     *
     * @param request  请求
     * @param response 返回
     * @param e        异常
     * @return 返回处理结果
     */
    @ExceptionHandler(value = Exception.class)
    public Object handlerException(HttpServletRequest request, HttpServletResponse response, Exception e) {
        e.printStackTrace();
        log.error(TAG, "handlerException");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("request", request);
        jsonObject.put("e", e);
        return ApiUtil.error(jsonObject);
    }

    @ExceptionHandler(value = RedisConnectionFailureException.class)
    public Object handlerRedisConnectionFailureException(HttpServletRequest request, HttpServletResponse response, RedisConnectionFailureException e) {
        e.printStackTrace();
        log.error(TAG, "handlerRedisConnectionFailureException");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("request", request);
        jsonObject.put("e", e);
        return ApiUtil.error(jsonObject);
    }
}
