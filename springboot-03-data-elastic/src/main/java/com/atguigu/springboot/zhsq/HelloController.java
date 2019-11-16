package com.atguigu.springboot.zhsq;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/8/19 15:48
 *
 */
@RestController
public class HelloController {

	@GetMapping("/hello")
	public String hello() {
		return "hello world";
	}
}
