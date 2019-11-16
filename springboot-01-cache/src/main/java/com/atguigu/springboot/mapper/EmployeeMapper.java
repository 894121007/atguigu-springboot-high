package com.atguigu.springboot.mapper;

import com.atguigu.springboot.bean.Department;
import com.atguigu.springboot.bean.Employee;
import org.apache.ibatis.annotations.*;

/**
 * @author Administrator
 * @description: TODO
 * @date 2019/7/16 22:25
 *
 */
@Mapper
public interface EmployeeMapper {

	@Select("SELECT * FROM employee WHERE id = #{id}")
	Employee getEmployee(Integer id);
}
