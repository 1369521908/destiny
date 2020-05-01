package com.gz.destinylegends.util.worn;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author Destiny_Xue
 * @Date 2019/10/4 17:22
 * @Description
 */
public class WornUtil {

    private static Lock lock = new ReentrantLock();

    public static String worn(String url) {

        lock.lock();

        try {
            JSONObject fakeParams = new JSONObject();
            fakeParams.put("xxxxx", System.currentTimeMillis() * Math.random());
            fakeParams.put("yyyyy", System.currentTimeMillis() * Math.random());
            fakeParams.put("zzzzz", System.currentTimeMillis() * Math.random());
            return HttpUtil.get(url, fakeParams);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            lock.unlock();
        }
    }
}
