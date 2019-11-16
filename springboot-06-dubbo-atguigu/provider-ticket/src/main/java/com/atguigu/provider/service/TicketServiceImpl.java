package com.atguigu.provider.service;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

@Component
@Service //将服务发布到注册中心
public class TicketServiceImpl implements TicketService{
	@Override
	public String getTicket() {
		return "复仇者联盟4--";
	}
}
