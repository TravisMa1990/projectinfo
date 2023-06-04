package com.ipdsys.flowmgt.controller;

import com.ipdsys.flowmgt.feign.ProjectInfoFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/FlowMgt")
public class FlowMgtController {

//    @Autowired
//    ProjectInfoFeignService projectInfoFeignService;

    @RequestMapping(path = "/nextStep",method = RequestMethod.POST)
    public String nextStep(@RequestBody String params){
//        projectInfoFeignService.entryTestPhase("123");
        return "abc";
    }
}
