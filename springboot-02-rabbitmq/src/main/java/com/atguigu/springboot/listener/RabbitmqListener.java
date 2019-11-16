package com.atguigu.springboot.listener;

import com.atguigu.springboot.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/22 17:24
 *
 */
@Component
public class RabbitmqListener {

	@RabbitListener(queues = {"atguigu"})
	public void receive1(Book book) {
		System.out.println("atguigu " + book);
	}

	@RabbitListener(queues = {"atguigu.news"})
	public void receive2(Object o) {
		System.out.println("atguigu.news " + o);
	}

	@RabbitListener(queues = {"atguigu.emps"})
	public void receive3(Message message) {
		System.out.println("atguigu.emps " + message);
		System.out.println("atguigu.emps " + message.getBody());
	}
}
