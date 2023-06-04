package com.ipdsys.flowmgt.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum CommonStatus {
    active(0,""),
    inactive(1,""),
    deleted(2,""),
    ;

    @EnumValue
    private final Integer value;
    private final String desc;

    CommonStatus(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
