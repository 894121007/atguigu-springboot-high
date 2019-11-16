package com.atguigu.springboot;

import com.atguigu.springboot.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot02RabbitmqApplicationTests {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	AmqpAdmin amqpAdmin;

	@Test
	public void createQuequ() {
		Queue queue = new Queue("amqpadmin.queue");
		amqpAdmin.declareQueue(queue);
	}

	@Test
	public void createExchanges() {
		amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange"));
	}

	@Test
	public void createBinding() {
		Binding binding = new Binding("amqpadmin.queue", Binding.DestinationType.QUEUE,"amqpadmin.exchange","amqpadmin.queue",null);
		amqpAdmin.declareBinding(binding);
	}

	@Test
	public void contextLoads() {
		Map<String,Object> map = new HashMap<>();
		map.put("data","hello");
		map.put("msg",1);
//		rabbitTemplate.convertAndSend("exchange.direct","atguigu",map);
		rabbitTemplate.convertAndSend("exchange.direct","atguigu",new Book("西游记","吴承恩"));
	}

	@Test
	public void receive() {
		Object atguigu = rabbitTemplate.receiveAndConvert("atguigu");
		System.out.println(atguigu.getClass());
		System.out.println(atguigu);
	}

	//广播,广播模式不需要路由键，因为是发送给所有绑定这个交换机的队列
	@Test
	public void sendMsg2() {
		rabbitTemplate.convertAndSend("exchange.fanout","",new Book("西游记","吴承恩"));
	}

	@Test
	public void sendMsg3() {
		rabbitTemplate.convertAndSend("exchange.topic","abc.news",new Book("红楼梦","曹雪芹"));
	}

}
