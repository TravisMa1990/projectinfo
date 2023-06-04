package com.ipdsys.flowmgt;

import com.alibaba.nacos.common.utils.CollectionUtils;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ActivitiProcessTest {

    private Logger logger = LoggerFactory.getLogger(ActivitiProcessTest.class);
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;

    @Test
    public void TestActivitiBase() {
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery()
//                .processDefinitionKey("Process_065ecni")
                .list();
        if (CollectionUtils.isNotEmpty(list)) {
            list.stream().map(ProcessDefinition::getName).forEach(System.out::println);
        }

//        runtimeService.startProcessInstanceByKey()
    }

    public void startOne(){

    }
}
