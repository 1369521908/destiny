package com.gz.destinylegends.entity;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;

/**
 * @Author Destiny_Xue
 * @Date 2019/10/3 0:48
 * @Description 召唤师技能
 */
@Data
@TableName
public class SummonerSkill implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "skillId", type = IdType.AUTO)
    private Long skillId;
    private String id;
    private String name;
    private String description;
    private String maxrank;
    @TableField(exist = false)
    private String key;
    private String skillKey;
    @TableField(exist = false)
    private JSONObject image;
    @TableField(value = "image", jdbcType = JdbcType.LONGVARCHAR)
    private String img;


}
