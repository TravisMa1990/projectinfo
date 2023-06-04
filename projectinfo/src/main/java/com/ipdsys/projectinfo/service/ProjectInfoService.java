package com.ipdsys.projectinfo.service;

import com.ipdsys.projectinfo.domain.ProjectInfo;
import com.ipdsys.projectinfo.dto.ListProjectInfoCondition;
import com.ipdsys.projectinfo.dto.ListResponse;
import com.ipdsys.projectinfo.dto.ProjectInfoDetail;

public interface ProjectInfoService {
    ProjectInfo createProjectInfo(ProjectInfo projectInfo);
    ProjectInfo getProjectInfo(String id);
    ProjectInfo updateProjectInfo(ProjectInfo projectInfo);

    ProjectInfo createProject(ProjectInfoDetail projectInfoDetail);

    ProjectInfo projectStart(ProjectInfoDetail projectInfoDetail);

    ListResponse<ProjectInfo> listProjectInfo(ListProjectInfoCondition cond);
}
