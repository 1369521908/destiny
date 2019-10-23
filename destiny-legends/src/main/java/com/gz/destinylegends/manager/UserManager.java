package com.gz.destinylegends.manager;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gz.destinylegends.entity.User;
import com.gz.destinylegends.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Destiny_Xue
 * @Date 2019/9/30 23:32
 * @Description
 */
@Service
public class UserManager {

    @Autowired
    private UserMapper userMapper;

    public boolean login(String userName, String password) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", userName).eq("password", password);
        User user = userMapper.selectOne(wrapper);
        return null != user;
    }


}
