package com.gz.destinylegends.dto;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gz.destinylegends.entity.Item;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Destiny_Xue
 * @Date 2019/10/4 14:54
 * @Description 版本物品数据
 */
@Data
@TableName
public class ItemPatch implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;

    @TableField(exist = false)
    private List<JSONObject> tree = new ArrayList<>();

    @TableField(jdbcType = JdbcType.LONGVARCHAR)
    private String treeList;

    @TableField(exist = false)
    private List<Item> items = new ArrayList<>();

    @TableField(jdbcType = JdbcType.LONGVARCHAR)
    private String itemList;

    private String version;

    private String fileName;

    private Date fileTime;

    private Date recodeTime;

}
