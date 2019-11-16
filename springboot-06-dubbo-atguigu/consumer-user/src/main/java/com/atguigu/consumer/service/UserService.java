package com.atguigu.consumer.service;

import com.atguigu.provider.service.TicketService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	@Reference
	TicketService ticketService;

	public String hello() {
		String ticket = ticketService.getTicket();
		return ticket;
	}
}
