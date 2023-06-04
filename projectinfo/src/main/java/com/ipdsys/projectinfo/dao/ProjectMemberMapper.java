package com.ipdsys.projectinfo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ipdsys.projectinfo.domain.ProjectMember;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProjectMemberMapper extends BaseMapper<ProjectMember> {
}
