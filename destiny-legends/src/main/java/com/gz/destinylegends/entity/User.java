package com.gz.destinylegends.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gz.destinylegends.enums.Sex;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

@Slf4j
@Data
@TableName
public class User implements Serializable {

    private static final long serialVersionUID = 4221940750991557547L;

    @TableId(type = IdType.AUTO)
    private Long id = 0L;

    /**
     * 性别
     */
    private Sex sex;

    /**
     * 账号
     */
    @NotBlank(message = "{required}")
    private String account = "";

    /**
     * 姓名
     */
    @NotBlank(message = "{required}")
    private String username = "";

    /**
     * 密码
     */
    private String password = "";

    /**
     * 标签
     */
    private String tag = "";

    /**
     * 头像
     */
    private String avatar = "";

    /**
     * 联系人列表
     */
    private String contactIdList;

    /**
     * 图片列表
     */
    private String pictureList;

    /**
     * 添加时间
     */
    private Date date = new Date();

    /**
     * 表头
     */
    @TableField(exist = false)
    private String token = "";
}
