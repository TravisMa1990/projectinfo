package com.ipdsys.flowmgt.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(value = "projectInfo",fallbackFactory = ProjectInfoFeignServiceHystrix.class)
public interface ProjectInfoFeignService {

    @RequestMapping(value = "/changeProjectStatus")
    String entryTestPhase(String projectId);
}
