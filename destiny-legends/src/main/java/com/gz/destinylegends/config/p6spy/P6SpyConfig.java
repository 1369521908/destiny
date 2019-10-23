package com.gz.destinylegends.config.p6spy;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

/**
 * @Author Destiny_Xue
 * @Date 2019/9/7 22:20
 * @Description p6spy输出配置
 */
public class P6SpyConfig implements MessageFormattingStrategy {
    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        return "连接id:" + connectionId + "|" + "当前时间:" + now + "|" + "耗时:" + elapsed + "|" +
                category+ "|" + prepared + "|" + sql + "|" + url;
    }
}
