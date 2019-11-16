package com.atguigu.springboot.service;

import com.atguigu.springboot.bean.Department;
import com.atguigu.springboot.bean.Employee;
import com.atguigu.springboot.mapper.DepartmentMapper;
import com.atguigu.springboot.mapper.EmployeeMapper;
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
@CacheConfig(cacheNames = "emp",cacheManager = "empCacheManager")
public class EmployeeService {

	Logger logger = LoggerFactory.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeMapper employeeMapper;

	@Cacheable(cacheNames = {"emp"})
	public Employee getEmployee(Integer id) {
		logger.info("查询" + id + "号员工");
		return employeeMapper.getEmployee(id);
	}

}
