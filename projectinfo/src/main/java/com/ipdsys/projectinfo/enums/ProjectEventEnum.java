package com.ipdsys.projectinfo.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum ProjectEventEnum {
    SCHEDULED_CONFIRM(1,""),
    REQUIREMENT_CONFIRM(2,""),
    DESIGN_CONFIRM(3,""),
    DEVELOP_FINISH(4,""),
    TEST_FINISH(5,""),
    DISTRIBUTION(6,""),
    ;

    @EnumValue
    private final Integer value;
    private final String desc;

    ProjectEventEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
