package com.ipdsys.projectinfo;

import com.ipdsys.projectinfo.domain.ProjectInfo;
import com.ipdsys.projectinfo.dto.ProjectEvent;
import com.ipdsys.projectinfo.enums.ProjectEventEnum;
import org.springframework.messaging.Message;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.stereotype.Component;

@Component
@WithStateMachine(name = "projectStateMachine")
public class ProjectStateListener {

    @OnTransition(source = "SCHEDULING",target = "REQUIREMENT_ANALYSIS")
    public void scheduledConfirm(Message<ProjectEventEnum> msg) {
//        ProjectEvent projectEvent = msg.getPayload();
//        ProjectInfo projectInfo = projectEvent.getProjectInfo();
        System.out.println("ProjectStateListener scheduledConfirm");
    }

}
