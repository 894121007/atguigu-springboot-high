package com.atguigu.springboot.controller;

import com.atguigu.springboot.bean.Department;
import com.atguigu.springboot.mapper.DepartmentMapper;
import com.atguigu.springboot.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/17 9:51
 *
 */
@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/dept/{id}")
	public Department getDepartment(@PathVariable Integer id) {
		Department department = departmentService.getDepartment(id);
		return department;
	}

	@PutMapping("/dept")
	public Department updateDepartment(Department department) {
		Department result = departmentService.updateDepartment(department);
		return result;
	}

	@DeleteMapping("/dept/{id}")
	public boolean deleteDepartment(@PathVariable Integer id) {
		return departmentService.deleteDepartment(id);
	}
}
