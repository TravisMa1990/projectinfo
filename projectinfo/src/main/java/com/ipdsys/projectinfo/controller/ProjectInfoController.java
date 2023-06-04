package com.ipdsys.projectinfo.controller;

import com.ipdsys.projectinfo.domain.ProjectInfo;
import com.ipdsys.projectinfo.service.ProjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projectInfo")
public class ProjectInfoController {

    @Autowired
    ProjectInfoService projectInfoService;
    @RequestMapping(path = "/get",method = RequestMethod.GET)
    public ProjectInfo getProjectInfo(String projectId){
        return projectInfoService.getProjectInfo(projectId);
    }

    @RequestMapping(path = "/projectInfo/changeProjectStatus",method = RequestMethod.POST)
    public ProjectInfo changeProjectStatus(@RequestBody ProjectInfo projectInfo) {
        return projectInfoService.updateProjectInfo(projectInfo);
    }
}
