package com.gz.destinylegends.controller.user;

import com.alibaba.fastjson.JSONObject;
import com.gz.destinylegends.constant.Constant;
import com.gz.destinylegends.controller.base.BaseController;
import com.gz.destinylegends.entity.User;
import com.gz.destinylegends.util.api.ApiUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("user")
public class UserController extends BaseController {

    /**
     * 登录
     * @param user 用户
     * @return 结果
     */
    @PostMapping("login")
    public Object login(@RequestBody User user) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        // 执行认证登陆
        try {
            subject.login(token);
        } catch (UnknownAccountException uae) {
//            return "未知账户";
        } catch (IncorrectCredentialsException ice) {
//            return "密码不正确";
        } catch (LockedAccountException lae) {
//            return "账户已锁定";
        } catch (ExcessiveAttemptsException eae) {
//            return "用户名或密码错误次数过多";
        } catch (AuthenticationException ae) {
            return ApiUtil.login(false);
//            return "用户名或密码不正确！";
        }
        if (subject.isAuthenticated()) {
            return ApiUtil.login(true);
        } else {
            token.clear();
            return ApiUtil.login(false);
        }
    }

    /**
     * TODO 修改成JWT
     * @param token
     * @return
     */
    @GetMapping("info")
    public Object info(String token) {

        JSONObject jsonObject = new JSONObject();
        List<String> list = new ArrayList<>();
        list.add("admin");
        jsonObject.put("roles", list);
        jsonObject.put("introduction","描述");
        jsonObject.put("avatar","https://avatars3.githubusercontent.com/u/32727597?s=460&v=4");
        jsonObject.put("name", "老大");
        jsonObject.put(Constant.TOKEN, token);
        return ApiUtil.success(jsonObject);
    }


    /**
     * 登出接口
     * @return 结果
     */
    @PostMapping("logout")
    public Object logout() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constant.DATA, Constant.SUCCESS);
        jsonObject.put(Constant.CODE, Constant.CODE_SUCCESS);
        return jsonObject;
    }

}
