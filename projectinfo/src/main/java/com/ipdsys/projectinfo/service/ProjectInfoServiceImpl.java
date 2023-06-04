package com.ipdsys.projectinfo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ipdsys.projectinfo.dao.ProjectInfoMapper;
import com.ipdsys.projectinfo.dao.ProjectMemberMapper;
import com.ipdsys.projectinfo.domain.ProjectInfo;
import com.ipdsys.projectinfo.domain.ProjectMember;
import com.ipdsys.projectinfo.dto.ListProjectInfoCondition;
import com.ipdsys.projectinfo.dto.ListResponse;
import com.ipdsys.projectinfo.dto.ProjectEvent;
import com.ipdsys.projectinfo.dto.ProjectInfoDetail;
import com.ipdsys.projectinfo.enums.MemberRoleEnum;
import com.ipdsys.projectinfo.enums.ProjectEventEnum;
import com.ipdsys.projectinfo.enums.ProjectStatusEnum;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectInfoServiceImpl implements ProjectInfoService{

    @Autowired
    ProjectInfoMapper projectInfoMapper;
    @Autowired
    ProjectMemberMapper projectMemberMapper;

    @Autowired
    StateMachine<ProjectStatusEnum, ProjectEventEnum> projectStateMachine;

    @Override
    public ProjectInfo createProjectInfo(ProjectInfo projectInfo) {
        return null;
    }

    @Override
    public ProjectInfo getProjectInfo(String id) {
        return null;
    }

    @Override
    public ProjectInfo updateProjectInfo(ProjectInfo projectInfo) {
        return null;
    }

    @Override
    public ProjectInfo createProject(ProjectInfoDetail projectInfoDetail) {
        ProjectInfo projectInfo = projectInfoDetail.getProjectInfo();
        projectInfo.setStatus(ProjectStatusEnum.SCHEDULING);
        projectInfoMapper.insert(projectInfo);

        List<ProjectMember> members = projectInfoDetail.getMembers();
        if (CollectionUtils.isNotEmpty(members)) {
            members.forEach(member -> member.setProjectId(projectInfo.getId()));
        } else {
            members = new ArrayList<>();
            ProjectMember manager = new ProjectMember();
            manager.setRoleType(MemberRoleEnum.PROJECT_MANAGER);
            manager.setProjectId(projectInfo.getId());
            manager.setUserId("1");
            manager.setMemberName("SystemUser");
            members.add(manager);
        }
        members.forEach(projectMemberMapper::insert);

        return projectInfo;
    }
    @Override
    public ProjectInfo projectStart(ProjectInfoDetail projectInfoDetail) {
        ProjectInfo projectInfo = projectInfoMapper.selectById(projectInfoDetail.getProjectInfo().getId());

        projectInfo.setStatus(ProjectStatusEnum.DESIGING);
        projectInfoMapper.updateById(projectInfo);

        LambdaQueryWrapper<ProjectMember> wrapper = new LambdaQueryWrapper<ProjectMember>()
                .eq(StringUtils.isNotEmpty(projectInfo.getId()),ProjectMember::getProjectId,projectInfo.getId());
        List<ProjectMember> oldProjectMembers = projectMemberMapper.selectList(wrapper);
        if (CollectionUtils.isNotEmpty(oldProjectMembers)) {
            oldProjectMembers.stream()
                    .map(ProjectMember::getId)
                    .forEach(projectMemberMapper::deleteById);
        }
        if (CollectionUtils.isNotEmpty(projectInfoDetail.getMembers())) {
            projectInfoDetail.getMembers().forEach(member -> {
                member.setProjectId(projectInfo.getId());
                projectMemberMapper.insert(member);
            });
        }

        projectStateMachine.start();
        ProjectEvent projectEvent = new ProjectEvent();
        projectEvent.setProjectInfo(projectInfo);
        Message<ProjectEventEnum> message = MessageBuilder
                .withPayload(ProjectEventEnum.SCHEDULED_CONFIRM)
                .setHeader("projectId", projectInfo.getId()).build();
        projectStateMachine.sendEvent(message);

        return projectInfo;
    }

    @Override
    public ListResponse<ProjectInfo> listProjectInfo(ListProjectInfoCondition cond){

        ListResponse<ProjectInfo> response = new ListResponse<>();

        Page<ProjectInfo> page = new Page<>();
        page.setSize(cond.getPageSize() + 1L);

        Long total = projectInfoMapper.countProjectInfo(cond);

        response.setTotal(total);

        if (total <= 0L) {
            return response;
        }

        IPage<ProjectInfo> resultSet = projectInfoMapper.listProjectInfo(page, cond);

        if (CollectionUtils.isEmpty(resultSet.getRecords())) {
            return response;
        }

        int resultSetSize = resultSet.getRecords().size();
        if (resultSetSize > cond.getPageSize()) {
            ProjectInfo last = resultSet.getRecords().get(resultSetSize - 1);
            response.setNextPageAnchor(last.getIdP());
            resultSet.getRecords().remove(resultSetSize - 1);
        }
        response.setList(resultSet.getRecords());

        return response;
    }

}
