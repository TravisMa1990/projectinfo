package com.ipdsys.projectinfo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ipdsys.projectinfo.controller.ProjectInfoController;
import com.ipdsys.projectinfo.domain.ProjectInfo;
import com.ipdsys.projectinfo.dao.ProjectInfoMapper;
import com.ipdsys.projectinfo.dto.ListProjectInfoCondition;
import com.ipdsys.projectinfo.dto.ListResponse;
import com.ipdsys.projectinfo.enums.ProjectStatusEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@SpringBootTest
class ProjectinfoApplicationTests {

	@Autowired
	ProjectInfoController projectInfoController;

	@Test
	void contextLoads() {
		projectInfoController.getProjectInfo("1");
	}

	@Autowired
	ProjectInfoMapper projectInfoMapper;

	@Test
	void testProjectInfoDAO(){
		List<String> names = List.of(new String[]{"airport", "lounge","toilet","cafe","garden"});
		ProjectInfo projectInfo = new ProjectInfo();

		QueryWrapper<ProjectInfo> idmWrapper = new QueryWrapper<>();
		idmWrapper.select("ifnull(max(id),0) as max_id");

		Map<String, Object> maxIdMap = projectInfoMapper.selectMaps(idmWrapper).stream().findAny().orElse(null);
		AtomicReference<Integer> maxId = new AtomicReference<>((Integer) maxIdMap.get("MAX_ID"));
		names.forEach(elem->{
			projectInfo.setId(String.valueOf(maxId.accumulateAndGet(1,(a,b)->a+b)));
			projectInfo.setName(elem);
			projectInfo.setStatus(ProjectStatusEnum.SCHEDULING);
			try {
				projectInfoMapper.insert(projectInfo);
			} catch (Exception e) {
				System.out.println(projectInfo);
			}
		});
	}

	@Test
	void testProjectInfoDAO1(){
//		ProjectInfo projectInfo = projectInfoMapper.selectById(1);
//		System.out.println(projectInfo.toString());

//		QueryWrapper wrapper = new QueryWrapper();
//		wrapper.ge("id_p","2");
//		Page<ProjectInfo> page = new Page<>();
//		page.setSize(2L);
//		Page page1 = projectInfoMapper.selectPage(page, wrapper);
//		page1.getRecords().forEach(System.out::println);

		Page<ProjectInfo> page = new Page<>();
		page.setSize(5L);
		ListProjectInfoCondition cond = new ListProjectInfoCondition();
		cond.setName("Project");
		IPage<ProjectInfo> page1 = projectInfoMapper.listProjectInfo(page, cond);
		page1.getRecords().forEach(System.out::println);

	}

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	void TestRedis(){
//		ValueOperations op = redisTemplate.opsForValue();
//		op.set("user-1001","Tom");
//		System.out.println(op.get("user-1001"));

		HashOperations hop = redisTemplate.opsForHash();
		ProjectInfo projectInfo = new ProjectInfo();
		projectInfo.setId("10001");
		projectInfo.setName("Guangzhou");
		projectInfo.setStatus(ProjectStatusEnum.DESIGING);
		hop.put("projectInfo",projectInfo.getId(),projectInfo);
		System.out.println(hop.get("projectInfo",projectInfo.getId()));

	}

}
