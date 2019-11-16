package com.atguigu.springboot.config;

import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.stereotype.Component;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/8/1 16:00
 *
 */
@Component
@WebEndpoint(id="myHello")
public class MyHello {

	@ReadOperation
	public String helloworld() {
		return "helloworld";
	}
}
