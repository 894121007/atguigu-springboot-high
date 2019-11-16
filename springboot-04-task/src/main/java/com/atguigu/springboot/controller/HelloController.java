package com.atguigu.springboot.controller;

import com.atguigu.springboot.service.HelloService;
import com.atguigu.springboot.service.SendHighEmailService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/24 15:44
 *
 */
@RestController
@RequestMapping(value = "/")
public class HelloController {

	@Autowired
	HelloService helloService;

	@Autowired
	private SendHighEmailService sendHighEmailService;

	@GetMapping("hello")
	public String hello() {
		//....在处理完逻辑之后，如果需要发送邮件，就要调用发送邮件方法，但是不需要返回成功的之前必须发送成功，
		//这个时候就可以使用异步任务了。
		helloService.sendMail();
		return "success";
	}

	/**
	 * @description: 发送包含html的邮件
	 * @return java.lang.String
	 * @throws
	 * @author zhanglong
	 * @date 2019/11/12 14:24
	 */
	@GetMapping("helloHtml")
	public String helloHtml() {
		//....在处理完逻辑之后，如果需要发送邮件，就要调用发送邮件方法，但是不需要返回成功的之前必须发送成功，
		//这个时候就可以使用异步任务了。
		helloService.sendHtmlMail();
		return "success";
	}

	@GetMapping("sendHighEmail")
	public String sendHighEmail() {
		try {
			sendHighEmailService.sendHighEmail();
		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "success";
	}

}
