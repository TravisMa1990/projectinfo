package com.ipdsys.projectinfo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.ipdsys.projectinfo.enums.ProjectStatusEnum;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class ProjectInfo {
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;
    private String name;
    private ProjectStatusEnum status;
    private Long idP;

    private Timestamp exptDesignedTime;
    private Timestamp exptTestingTime;
    private Timestamp deadLine;

    private Timestamp scheduledTime;
    private Timestamp designStartTime;
    private Timestamp developStartTime;
    private Timestamp testingStartTime;

}
