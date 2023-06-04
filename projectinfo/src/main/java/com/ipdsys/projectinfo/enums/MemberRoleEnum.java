package com.ipdsys.projectinfo.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

@Getter
public enum MemberRoleEnum {
    PROJECT_MANAGER(1,""),
    PRODUCT_MANAGER(2,""),
    UI_UE(3,""),
    DEVELOPER(4,""),
    TESTING(5,""),
    ;

    @EnumValue
    private final Integer value;
    private final String desc;

    MemberRoleEnum(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }
}
