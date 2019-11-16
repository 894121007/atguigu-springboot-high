package com.atguigu.springboot;

import com.atguigu.springboot.bean.Department;
import com.atguigu.springboot.bean.Employee;
import com.atguigu.springboot.mapper.DepartmentMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.naming.ldap.Rdn;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot01CacheApplicationTests {

	@Autowired
	DepartmentMapper departmentMapper;

	@Autowired
	StringRedisTemplate stringRedisTemplate;

	@Autowired
	RedisTemplate redisTemplate;

//	@Autowired
//	RedisTemplate redisTemplate;

	@Test
	public void contextLoads() {
		Department department = departmentMapper.getDepartment(1);
		System.out.println(department);
	}

	@Test
	public void test01() {
		//操作String
		stringRedisTemplate.opsForValue().set("msg","hello world");
		String msg = stringRedisTemplate.opsForValue().get("msg");
		System.out.println(msg);

		//操作List
		stringRedisTemplate.opsForList().leftPush("myList","a");
		stringRedisTemplate.opsForList().leftPush("myList","b");
		stringRedisTemplate.opsForList().leftPush("myList","c");
		stringRedisTemplate.opsForList().leftPush("myList","d");
		stringRedisTemplate.opsForList().leftPush("myList","e");
		String myList = stringRedisTemplate.opsForList().index("myList",1);
		List<String> myList2 = stringRedisTemplate.opsForList().range("myList",1,3);
		System.out.println(myList);
		System.out.println(myList2);

	}

	@Test
	public void test02() {
		Department department = new Department();
		department.setId(1);
		department.setDepartmentName("研发部");
		redisTemplate.opsForValue().set("dept01",department);
	}

	@Test
	public void test03() {
		Department department = new Department();
		department.setId(1);
		department.setDepartmentName("研发部22");
		redisTemplate.opsForValue().set("dept02",department);
	}

	@Test
	public void test04() {
//		Department department = new Department();
//		department.setId(1);
//		department.setDepartmentName("研发部22");
		Employee employee = new Employee();
		employee.setId(1);
		employee.setLastName("张三");
		employee.setEmail("zhanglong@qq.com");
		employee.setGender(1);
		redisTemplate.opsForValue().set("emp01",employee);
	}

}
