package com.ipdsys.projectinfo.dto;

import lombok.Data;

import java.util.List;

@Data
public class ListResponse<T> {
    private List<T> list;
    private Long nextPageAnchor;
    private Long total;
}
