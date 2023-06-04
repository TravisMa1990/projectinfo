package com.ipdsys.projectinfo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ipdsys.projectinfo.domain.ProjectInfo;
import com.ipdsys.projectinfo.dto.ListProjectInfoCondition;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProjectInfoMapper extends BaseMapper<ProjectInfo> {

    Long countProjectInfo(@Param("params") ListProjectInfoCondition params);

    IPage<ProjectInfo> listProjectInfo(Page<ProjectInfo> page, @Param("params") ListProjectInfoCondition params);
}
