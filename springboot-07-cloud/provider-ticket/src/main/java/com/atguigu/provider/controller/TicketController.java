package com.atguigu.provider.controller;

import com.atguigu.provider.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/31 12:34
 *
 */
@RestController
public class TicketController {

	@Autowired
	TicketService ticketService;

	@GetMapping("/ticket")
	public String getTicket() {
		return ticketService.getTicket();
	}
}
