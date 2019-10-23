package com.gz.destinylegends.annotation;

import java.lang.annotation.*;

/**
 * @Author Destiny_Xue
 * @Date 2019/9/10 21:54
 * @Description
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD })
public @interface Header {

    /**
     * 注解参数key值
     * @return value
     */
    String header() default "";
}
