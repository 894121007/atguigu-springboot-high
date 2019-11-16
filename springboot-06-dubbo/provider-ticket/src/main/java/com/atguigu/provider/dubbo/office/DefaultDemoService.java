package com.atguigu.provider.dubbo.office;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/29 13:53
 *
 */
@Service
public class DefaultDemoService implements DemoService {

	/**
	 * The default value of ${dubbo.application.name} is ${spring.application.name}
	 */
	@Value("${dubbo.application.name}")
	private String serviceName;

	public String sayHello(String name) {
		return String.format("[%s] : Hello, %s", serviceName, name);
	}
}
