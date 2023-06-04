package com.ipdsys.flowmgt.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;

@Component
public class FlowMgtServiceImpl implements FlowMgtService {

    Logger logger = LoggerFactory.getLogger(FlowMgtServiceImpl.class);
    @Resource
    ExecutorService threadExecutor;

    @Override
    public void nextMove() {
        threadExecutor.execute(()->{
            logger.info("thread running");

            logger.info("thread running");
        });

        logger.info("main running");

        logger.info("main running");

    }
}
