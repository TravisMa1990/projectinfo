package com.ipdsys.projectinfo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ipdsys.projectinfo.enums.MemberRoleEnum;
import lombok.Data;

@Data
public class ProjectMember {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    private String memberName;
    private Long idP;
    private String projectId;
    private String userId;
    private MemberRoleEnum roleType;

}
