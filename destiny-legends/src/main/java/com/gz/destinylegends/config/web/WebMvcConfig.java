package com.gz.destinylegends.config.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Description springMVC 配置类
 * @Author by xueqichang
 * @Email 1369521908@qq.com
 * @Date 2019/9/28 11:51
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    /**
     * 跨越处理
     * @param registry 跨域注册器
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .maxAge(3600)
                .allowCredentials(true);
    }
}
