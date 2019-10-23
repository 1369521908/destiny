package com.gz.destinylegends.controller.test;

import com.alibaba.fastjson.JSONObject;
import com.gz.destinylegends.controller.base.BaseController;
import org.beetl.core.GroupTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController extends BaseController {

    @Autowired
    GroupTemplate groupTemplate;

    @GetMapping("beetl")
    public Object beetl() {
        System.out.println(JSONObject.toJSONString(groupTemplate));
        return null;
    }


}
