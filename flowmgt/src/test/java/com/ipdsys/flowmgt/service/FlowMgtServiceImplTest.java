package com.ipdsys.flowmgt.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FlowMgtServiceImplTest {

    @Autowired
    FlowMgtService flowMgtService;
    @Test
    void nextMove() {
        flowMgtService.nextMove();
    }
}