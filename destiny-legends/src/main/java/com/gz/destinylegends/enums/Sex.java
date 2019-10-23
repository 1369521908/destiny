package com.gz.destinylegends.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;
import lombok.AllArgsConstructor;

/**
 * @author 13695
 */

@AllArgsConstructor
public enum Sex implements IEnum<Integer> {

    /**
     * 男性
     */
    Male(0,"男"),
    /**
     * 女性
     */
    FeMale(1,"女");

    private int value;
    private String desc;

    @Override
    public Integer getValue() {
        return this.value;
    }
}
