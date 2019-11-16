package com.atguigu.springboot.service;

import com.atguigu.springboot.bean.Department;
import com.atguigu.springboot.bean.Employee;
import com.atguigu.springboot.mapper.DepartmentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/17 10:56
 *
 */
@Service
@CacheConfig(cacheNames = "dept",cacheManager = "deptCacheManager")
public class DepartmentService {

	Logger logger = LoggerFactory.getLogger(DepartmentService.class);

	@Autowired
	private DepartmentMapper departmentMapper;

	@Cacheable(cacheNames = {"dept"})
	public Department getDepartment(Integer id) {
		logger.info("查询" + id + "号员工");
		return departmentMapper.getDepartment(id);
	}

	@CachePut(cacheNames = "dept",key = "#result.id")
	public Department updateDepartment(Department department) {
		departmentMapper.updateDepartment(department);
		return department;
	}

	@Caching
	@CacheEvict(cacheNames = "dept",key = "#id")
	public boolean deleteDepartment(Integer id) {
		Integer integer = departmentMapper.deleteDepartment(id);
		return integer == 1;
	}

	@Caching(
			cacheable = {
					@Cacheable(cacheNames = "dept",key = "#id")
			},
			put = {
					@CachePut(cacheNames = "dept",key = "#result.id"),
					@CachePut(cacheNames = "dept",key = "#result.departmentName")
			}
	)
	public Department test(Integer id) {
		return new Department();
	}
}
