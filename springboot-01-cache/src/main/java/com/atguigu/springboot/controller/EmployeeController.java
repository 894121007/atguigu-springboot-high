package com.atguigu.springboot.controller;

import com.atguigu.springboot.bean.Department;
import com.atguigu.springboot.bean.Employee;
import com.atguigu.springboot.service.DepartmentService;
import com.atguigu.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/17 9:51
 *
 */
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/emp/{id}")
	public Employee getEmployee(@PathVariable Integer id) {
		Employee employee = employeeService.getEmployee(id);
		return employee;
	}

}
