package com.atguigu.springboot.mapper;

import com.atguigu.springboot.bean.Department;
import org.apache.ibatis.annotations.*;

/**
 * @author Administrator
 * @description: TODO
 * @date 2019/7/16 22:25
 *
 */
@Mapper
public interface DepartmentMapper {

	@Select("SELECT * FROM department WHERE id = #{id}")
	Department getDepartment(Integer id);

	@Insert("INSERT department (departmentName) VALUES (#{departmentName})")
	Integer insertDepartment(Department department);

	@Update("UPDATE department SET departmentName = #{departmentName} WHERE id = #{id}")
	Integer updateDepartment(Department department);

	@Delete("DELETE FROM department WHERE id = #{id}")
	Integer deleteDepartment(Integer id);
}
