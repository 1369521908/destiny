package com.gz.destinylegends.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gz.destinylegends.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Mapper
@Repository
public interface UserMapper extends BaseMapper<User> {
}
