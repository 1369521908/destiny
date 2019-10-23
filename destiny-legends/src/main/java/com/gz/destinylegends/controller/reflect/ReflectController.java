package com.gz.destinylegends.controller.reflect;

import com.gz.destinylegends.entity.User;
import com.gz.destinylegends.util.header.AvueHeader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Destiny_Xue
 * @Date 2019/9/10 21:33
 * @Description
 */
@RestController
@RequestMapping("reflect")
public class ReflectController {

    @GetMapping
    public Object test(User user) throws ClassNotFoundException {
        // 反射练习
        String build = AvueHeader.build(User.class);
        return build;
    }

}
