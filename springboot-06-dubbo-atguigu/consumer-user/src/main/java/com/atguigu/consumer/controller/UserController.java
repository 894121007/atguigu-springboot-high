package com.atguigu.consumer.controller;

import com.atguigu.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/29 14:34
 *
 */
@RestController
@RequestMapping("/")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("hello")
	public String hello() {
		return userService.hello();
	}
}
