package com.gz.destinylegends.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gz.destinylegends.util.header.AvueHeader;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author Destiny_Xue
 * @Date 2019/9/12 1:04
 * @Description
 */
@Data
@TableName
public class HeroSpell implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * heroid
     */
    private Long heroId;

    /**
     * spellkey
     */
    private String spellKey;

    /**
     * name
     */
    private String name;

    /**
     * description
     */
    private String description;

    /**
     * abilityiconpath
     */
    private String abilityIconPath;

    /**
     * abilityvideopath
     */
    private String abilityVideoPath;

    /**
     * dynamicdescription
     */
    private String dynamicDescription;

    /**
     * cost
     */
    private String cost;

    /**
     * costburn
     */
    private String costburn;

    /**
     * cooldown
     */
    private String cooldown;

    /**
     * cooldownburn
     */
    private String cooldownburn;

    /**
     * range value解决冲突
     */
    @TableField(value = "`range`")
    private String range;

    /**
     * 表头
     */
//    @TableField(exist = false)
//    private String header = AvueHeader.build(User.class);
}