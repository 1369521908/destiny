package com.gz.destinylegends.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Destiny_Xue
 * @Date 2019/10/4 15:10
 * @Description
 */
@Data
@TableName
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Long itemId;
    private String name;
    private String iconPath;
    private Integer price;
    @TableField(jdbcType = JdbcType.LONGVARCHAR)
    private String description;
    @TableField(exist = false)
    private List<String> maps = new ArrayList<>();
    @TableField(jdbcType = JdbcType.LONGVARCHAR)
    private String mapList;
    private String plaintext;
    private Integer sell;
    private Integer total;
    @TableField(exist = false)
    private List<Long> into = new ArrayList<>();
    @TableField(jdbcType = JdbcType.LONGVARCHAR)
    private String intoList;
    @TableField(exist = false)
    private List<Long> from = new ArrayList<>();
    private String fromItems;
    private String suitHeroId;
    private String tag;
    @TableField(exist = false)
    private List<String> types = new ArrayList<>();
    @TableField(jdbcType = JdbcType.LONGVARCHAR)
    private String typeList;
}
