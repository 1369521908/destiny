package com.gz.destinylegends.controller.test;

import com.gz.destinylegends.controller.base.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController extends BaseController {

    // @Autowired
    // GroupTemplate groupTemplate;

    @GetMapping("beetl")
    public Object beetl() {
        // System.out.println(JSONObject.toJSONString(groupTemplate));
        return null;
    }


}
