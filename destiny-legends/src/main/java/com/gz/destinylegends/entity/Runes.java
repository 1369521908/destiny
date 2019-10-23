package com.gz.destinylegends.entity;

import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;

/**
 * @Author Destiny_Xue
 * @Date 2019/10/4 16:34
 * @Description
 */
@Data
@TableName
public class Runes implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String slogan;
    private String description;

    @TableField(exist = false)
    private JSONArray bonuses;

    @TableField(jdbcType = JdbcType.LONGVARCHAR)
    private String bonusesList;

    @TableField(exist = false)
    private JSONArray slots;

    @TableField(jdbcType = JdbcType.LONGVARCHAR)
    private String slotList;
}
