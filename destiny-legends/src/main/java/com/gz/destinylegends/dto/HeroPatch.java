package com.gz.destinylegends.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gz.destinylegends.entity.HeroDetail;
import com.gz.destinylegends.entity.HeroSkin;
import com.gz.destinylegends.entity.HeroSpell;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Author Destiny_Xue
 * @Date 2019/9/12 1:13
 * @Description
 */
@Data
@TableName
public class HeroPatch implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField(exist = false)
    private HeroDetail hero;

    @TableField(jdbcType = JdbcType.LONGVARCHAR)
    private String heroInfo;

    @TableField(exist = false)
    private List<HeroDetail> heroDetailList;

    @TableField(jdbcType = JdbcType.LONGVARCHAR)
    private String heroList;

    @TableField(exist = false)
    private List<HeroSkin> skins;

    @TableField(jdbcType = JdbcType.LONGVARCHAR)
    private String skinList;

    @TableField(exist = false)
    private List<HeroSpell> spells;

    @TableField(jdbcType = JdbcType.LONGVARCHAR)
    private String spellList;

    private String version;

    private String fileName;

    private Date fileTime;

    private Date recodeTime;

}
