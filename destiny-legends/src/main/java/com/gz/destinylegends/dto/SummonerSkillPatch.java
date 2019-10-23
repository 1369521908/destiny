package com.gz.destinylegends.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gz.destinylegends.entity.SummonerSkill;
import lombok.Data;
import org.apache.ibatis.type.JdbcType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author Destiny_Xue
 * @Date 2019/10/3 22:53
 * @Description
 */
@Data
@TableName
public class SummonerSkillPatch implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;
    private String version = "";
    @TableField(exist = false)
    private List<SummonerSkill> skills = new ArrayList<>();
    @TableField(jdbcType = JdbcType.LONGVARCHAR)
    private String skillList = "";
    private Date updated;
    private Date recodeTime;
}
