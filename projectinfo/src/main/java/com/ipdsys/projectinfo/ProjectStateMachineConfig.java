package com.ipdsys.projectinfo;

import com.ipdsys.projectinfo.enums.ProjectEventEnum;
import com.ipdsys.projectinfo.enums.ProjectStatusEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

@Configuration
@EnableStateMachine(name = "projectStateMachine")
public class ProjectStateMachineConfig extends StateMachineConfigurerAdapter<ProjectStatusEnum, ProjectEventEnum> {
    @Override
    public void configure(StateMachineStateConfigurer<ProjectStatusEnum, ProjectEventEnum> states) throws Exception {
        states.withStates()
                .initial(ProjectStatusEnum.SCHEDULING)
                .states(EnumSet.allOf(ProjectStatusEnum.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<ProjectStatusEnum, ProjectEventEnum> transitions) throws Exception {
        transitions.withExternal()
                .source(ProjectStatusEnum.SCHEDULING).target(ProjectStatusEnum.REQUIREMENT_ANALYSIS)
                .event(ProjectEventEnum.SCHEDULED_CONFIRM)
                .and().withExternal()
                .source(ProjectStatusEnum.REQUIREMENT_ANALYSIS).target(ProjectStatusEnum.DESIGING)
                .event(ProjectEventEnum.REQUIREMENT_CONFIRM)
                .and().withExternal()
                .source(ProjectStatusEnum.DESIGING).target(ProjectStatusEnum.DEVELOPING)
                .event(ProjectEventEnum.DESIGN_CONFIRM)
                .and().withExternal()
                .source(ProjectStatusEnum.DEVELOPING).target(ProjectStatusEnum.TESTING)
                .event(ProjectEventEnum.DEVELOP_FINISH)
                .and().withExternal()
                .source(ProjectStatusEnum.TESTING).target(ProjectStatusEnum.CLOSED)
                .event(ProjectEventEnum.DISTRIBUTION)
        ;
    }

}
