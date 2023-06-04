package com.ipdsys.projectinfo.service;

import com.ipdsys.projectinfo.domain.ProjectInfo;
import com.ipdsys.projectinfo.domain.ProjectMember;
import com.ipdsys.projectinfo.dto.ListProjectInfoCondition;
import com.ipdsys.projectinfo.dto.ListResponse;
import com.ipdsys.projectinfo.dto.ProjectInfoDetail;
import com.ipdsys.projectinfo.enums.MemberRoleEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProjectInfoServiceTests {

    @Autowired
    ProjectInfoService projectInfoService;

    @Test
    void listProjectInfoTest(){
        ListProjectInfoCondition cond = new ListProjectInfoCondition();
        cond.setPageSize(3L);
        cond.setPageAnchor(3L);
        cond.setName("PPP");
        ListResponse<ProjectInfo> response = projectInfoService.listProjectInfo(cond);
        System.out.println(response);
    }

    @Test
    public void createProjectTest() {
        ProjectInfoDetail projectInfoDetail = new ProjectInfoDetail();
        ProjectInfo projectInfo = new ProjectInfo();
        projectInfo.setName("Project" + (int) (Math.random()*1000000));
        projectInfoDetail.setProjectInfo(projectInfo);
        ProjectInfo project = projectInfoService.createProject(projectInfoDetail);
        System.out.println(project);
    }

    @Test
    public void projectStartTest(){
        ProjectInfoDetail projectInfoDetail = new ProjectInfoDetail();
        ProjectInfo projectInfo = new ProjectInfo();
        projectInfo.setId("1");
        projectInfoDetail.setProjectInfo(projectInfo);
        ProjectMember projectMember = new ProjectMember();
        projectMember.setMemberName("Tom");
        projectMember.setRoleType(MemberRoleEnum.PROJECT_MANAGER);
        projectInfoService.projectStart(projectInfoDetail);
    }
}
