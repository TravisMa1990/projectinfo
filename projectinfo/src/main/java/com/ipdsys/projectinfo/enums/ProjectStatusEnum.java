package com.ipdsys.projectinfo.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum ProjectStatusEnum {
    SCHEDULING(1,""),
    REQUIREMENT_ANALYSIS(2,""),
    DESIGING(3,""),
    DEVELOPING(4,""),
    TESTING(5,""),
    CLOSED(6,""),
    ;

    @EnumValue
    private final Integer value;
    private final String desc;

    ProjectStatusEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
