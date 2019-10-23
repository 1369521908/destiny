package com.gz.destinylegends.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gz.destinylegends.util.header.AvueHeader;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author Destiny_Xue
 * @Date 2019/9/12 0:19
 * @Description
 */
@Data
@TableName
public class HeroSkin implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     *
     */
    private Long heroId;

    /**
     *
     */
    private String heroName;

    /**
     *
     */
    private String heroTitle;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private Integer chromas;

    /**
     *
     */
    private Integer chromasBelongId;

    /**
     *
     */
    private Boolean isBase;

    /**
     *
     */
    private String emblemsName;

    /**
     *
     */
    private String description;

    /**
     *
     */
    private String mainImg;

    /**
     *
     */
    private String iconImg;

    /**
     *
     */
    private String loadingImg;

    /**
     *
     */
    private String videoImg;

    /**
     *
     */
    private String sourceImg;

    /**
     *
     */
    private String vedioPath;

    /**
     *
     */
    private String suitType;

    /**
     *
     */
    private Date publishTime;

    /**
     *
     */
    private String chromaImg;

    /**
     * 表头
     */
//    @TableField(exist = false)
//    private String header = AvueHeader.build(User.class);
}
