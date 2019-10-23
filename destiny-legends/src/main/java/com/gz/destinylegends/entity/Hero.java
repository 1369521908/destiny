package com.gz.destinylegends.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author Destiny_Xue
 * @Date 2019/9/11 22:54
 * @Description 英雄基本信息
 */
@Data
@TableName
public class Hero implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 爬取数据set为heroId
     */
//    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 英雄id(官方)
     */
    private Long heroId;

    /**
     * 英雄名称(中文,官方,例如:黑暗之女)
     */
    private String name;

    /**
     * 英雄名称(英文别名,官方,例如:Annie)
     */
    private String alias;

    /**
     * 英雄名称(中文别名,官方,例如:安妮)
     */
    private String title;

    /**
     * 属性位置(官方,例如:mage, tank,即:法师,坦克)
     */
    @TableField(exist = false)
    private List<String> roles;

    /**
     * 属性位置(官方,例如:mage, tank,即:法师,坦克)
     */
    @TableField(value = "roles")
    private String role;

    /**
     * 是否周免(官方,永久周免?)
     */
    private Boolean isWeekFree;

    /**
     * 物理攻击,六芒星属性值(官方,参考值:2)
     */
    private Integer attack;

    /**
     * 防御能力,六芒星属性值(官方,参考值:3)
     */
    private Integer defense;

    /**
     * 魔法攻击,六芒星属性值(官方,参考值:10)
     */
    private Integer magic;

    /**
     * 上手难度,六芒星属性值(官方,参考值:6)
     */
    private Integer difficulty;

    /**
     * 英雄被选择音效(官方,参考值:https://game.gtimg.cn/images/lol/act/img/vo/choose/1.ogg)
     */
    private String selectAudio;

    /**
     * 英雄被ban音效(官方,参考值:https://game.gtimg.cn/images/lol/act/img/vo/ban/1.ogg)
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
//    private String header = AvueHeader.build(Hero.class);
}
