package com.atguigu.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/31 14:07
 *
 */
@RestController
public class HelloController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/hello")
	public String hello() {
		String result = restTemplate.getForObject("http://PROVIDER-TICKET/ticket", String.class);
		return result;
	}
}
