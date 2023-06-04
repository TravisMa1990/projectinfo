package com.ipdsys.projectinfo.dto;

import com.ipdsys.projectinfo.domain.ProjectInfo;
import com.ipdsys.projectinfo.domain.ProjectMember;
import lombok.Data;

import java.util.List;

@Data
public class ProjectInfoDetail {

    private ProjectInfo projectInfo;
    private List<ProjectMember> members;
}
