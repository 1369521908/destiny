package com.gz.destinylegends.controller.destiny;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gz.destinylegends.controller.base.BaseController;
import com.gz.destinylegends.entity.User;
import com.gz.destinylegends.mapper.UserMapper;
import com.gz.destinylegends.util.api.ApiUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @Description 练习
 * @Author by xueqichang
 * @Email 1369521908@qq.com
 * @Date 2019/9/28 11:51
 */
@Validated
@RestController
@RequestMapping("destiny")
public class DestinyController extends BaseController {

    @Autowired
    private UserMapper userMapper;

    /**
     * TODO 排序和过滤后面优化
     *
     * @return
     */
    @GetMapping
    public Object list(Long pageSize,Long currentPage) {
        IPage<User> userIPage = new Page<>(currentPage,pageSize);
        IPage<User> usersIPage = userMapper.selectPage(userIPage, null);
        return ApiUtil.success(usersIPage);
    }

    @PostMapping
    public Object insert(@Valid User user) {
        int insert = userMapper.insert(user);
        if (insert == 0) {
            return ApiUtil.error();
        }
        return ApiUtil.success();
    }

    @DeleteMapping("/{id}")
    public Object delete(@PathVariable Long id){
        int delete = userMapper.deleteById(id);
        if (delete == 0) {
            return ApiUtil.error();
        }
        return ApiUtil.success();
    }

    @PutMapping
    public Object update(@Valid User user){
        int update = userMapper.updateById(user);
        if (update == 0) {
            return ApiUtil.error();
        }
        return ApiUtil.success();

    }

}
