package com.gz.destinylegends.config.beetl;

import lombok.extern.slf4j.Slf4j;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.CompositeResourceLoader;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Configurable
@Slf4j
@Component
public class BeetlConfig {

    /**
     * 全局 GroupTemplate 单例 ,使用时建议使用注入方式取得对象
     *
     * @return
     */
    @Bean(name = "groupTemplate")
    public GroupTemplate groupTemplate() {
        try {
            CompositeResourceLoader loader = new CompositeResourceLoader();

            Configuration configuration = Configuration.defaultConfiguration();

            GroupTemplate groupTemplate = new GroupTemplate(loader, configuration);
            log.debug("配置beetl groupTemplate :{}", groupTemplate);
            return groupTemplate;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
