package com.gz.destinylegends.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Destiny_Xue
 * @Date 2019/9/12 0:14
 * @Description 英雄详细信息
 */
@Data
@TableName
public class HeroDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 爬取数据set为heroId
     */
//    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * heroid
     */
    private Long heroId;

    /**
     * name
     */
    private String name;

    /**
     * alias
     */
    private String alias;

    /**
     * title
     */
    private String title;

    /**
     * roles
     */
    @TableField(exist = false)
    private List<String> roles;

    @TableField(value = "roles")
    private String role;

    /**
     * shortbio 简短描述
     */
    private String shortBio;

    /**
     * camp 阵营
     */
    private String camp;

    /**
     * attack 攻击倾向值
     */
    private Integer attack;

    /**
     * defense 防御倾向值
     */
    private Integer defense;

    /**
     * magic 法术倾向值
     */
    private Integer magic;

    /**
     * difficulty 操作难度倾向值
     */
    private Integer difficulty;

    /**
     * hp 起始生命值
     */
    private Double hp;

    /**
     * hpperlevel
     */
    private Double hpperlevel;

    /**
     * mp
     */
    private Double mp;

    /**
     * mpperlevel
     */
    private Double mpperlevel;

    /**
     * movespeed
     */
    private Double movespeed;

    /**
     * armor
     */
    private Double armor;

    /**
     * armorperlevel
     */
    private Double armorperlevel;

    /**
     * spellblock
     */
    private Double spellblock;

    /**
     * spellblockperlevel
     */
    private Double spellblockperlevel;

    /**
     * attackrange
     */
    private Double attackrange;

    /**
     * hpregen
     */
    private Double hpregen;

    /**
     * hpregenperlevel
     */
    private Double hpregenperlevel;

    /**
     * mpregen
     */
    private Double mpregen;

    /**
     * mpregenperlevel
     */
    private Double mpregenperlevel;

    /**
     * crit
     */
    private Double crit;

    /**
     * critperlevel
     */
    private Double critperlevel;

    /**
     * attackdamage
     */
    private Double attackdamage;

    /**
     * attackdamageperlevel
     */
    private Double attackdamageperlevel;

    /**
     * attackspeed
     */
    private Double attackspeed;

    /**
     * attackspeedperlevel
     */
    private Double attackspeedperlevel;

    /**
     * allytips
     */
    private String allytips;

    /**
     * enemytips
     */
    private String enemytips;

    /**
     * herovideopath
     */
    private String heroVideoPath;

    /**
     * isweekfree
     */
    private Boolean isWeekFree;

    /**
     * damagetype
     */
    private String damageType;

    /**
     * style
     */
    private Integer style;

    /**
     * difficultyl
     */
    private Integer difficultyL;

    /**
     * damage
     */
    private Integer damage;

    /**
     * durability
     */
    private Integer durability;

    /**
     * crowdcontrol
     */
    private Integer crowdControl;

    /**
     * mobility
     */
    private Integer mobility;

    /**
     * utility
     */
    private Integer utility;

    /**
     * selectaudio
     */
    private String selectAudio;

    /**
     * banaudio
     */
    private String banAudio;

    /**
     * 英雄图标
     */
    private String avatar;

    /**
     * 表头
     */
//    @TableField(exist = false)
//    private String header = AvueHeader.build(User.class);
}
