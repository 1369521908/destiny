package com.gz.destinylegends.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gz.destinylegends.entity.Runes;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author Destiny_Xue
 * @Date 2019/10/4 16:28
 * @Description
 */
@Data
@TableName
public class RunesPatch implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField(exist = false)
    private List<Runes> styles;

    @TableField(jdbcType = JdbcType.LONGVARCHAR)
    private String styleList;

    private Date recodeTime;
}
