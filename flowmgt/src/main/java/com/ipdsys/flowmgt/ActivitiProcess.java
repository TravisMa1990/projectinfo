package com.ipdsys.flowmgt;

import org.activiti.engine.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class ActivitiProcess {
    @Autowired
    private RepositoryService repositoryService;

    @PostConstruct
    public void init(){
//        repositoryService.createDeployment()
//                .addClasspathResource("proccesses/normalDm.bpmn")
//                .deploy();
    }
}
