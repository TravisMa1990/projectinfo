package com.ipdsys.projectinfo.dto;

import com.ipdsys.projectinfo.domain.ProjectInfo;
import com.ipdsys.projectinfo.domain.ProjectMember;
import lombok.Data;

import java.util.List;
import java.util.concurrent.locks.LockSupport;

@Data
public class ProjectEvent {
    ProjectInfo projectInfo;
    List<ProjectMember> projectMembers;
}
