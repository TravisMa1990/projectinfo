package com.ipdsys.projectinfo.dto;

import lombok.Data;

@Data
public class ListProjectInfoCondition {
    private Long pageAnchor;
    private Long pageSize;
    private String name;
}
