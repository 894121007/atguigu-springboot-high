package com.atguigu.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/24 15:45
 *
 */
@Service
public class HelloService {

	@Autowired
	private JavaMailSenderImpl javaMailSender;

	@Autowired
	private JavaMailSender mailSender;


	@Async
	public void sendMail() {
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("zhanglong_xinhua@163.com");
		msg.setFrom("894121007@qq.com");
		msg.setSubject("标题：hello world");
//		msg.setText("邮件内容：你好，邮件发送成功！<a href='https://www.baidu.com/'>https://www.baidu.com/</a>");
		msg.setText("<!DOCTYPE html>\n" +
				"<html>\n" +
				"    <head>\n" +
				"        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
				"    </head>\n" +
				"    <body>\n" +
				"        邮件内容：你好，邮件发送成功！<a href='https://www.baidu.com/'>https://www.baidu.com/" +
				"    </body>\n" +
				"</html>\n");
		mailSender.send(msg);
		System.out.println("邮件发送成功！！！");
	}

	@Async
	public void sendHtmlMail() {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = null;
		try {
			messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
			messageHelper.setFrom("894121007@qq.com");
			messageHelper.setTo("zhanglong_xinhua@163.com");
			messageHelper.setSubject("my subject");
			messageHelper.setText("邮件内容：你好，邮件发送成功！<a href='https://www.baidu.com/'>https://www.baidu.com/</a>", true);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		mailSender.send(mimeMessage);
		System.out.println("邮件发送成功！！！");
	}

	/**
	 * second(秒) as well as minute（分）, hour（小时）, day of month（日）, month（月） and day of week（星期）
	 */
	//简单定时任务
//	@Scheduled(cron = "0 * * * * *")  //只要是秒是 0 的时候，都执行
//	@Scheduled(cron = "0,1,2,3,4 * * * * *") //枚举：秒是0，1，2，3，4 的时候执行
//	@Scheduled(cron = "0-10 * * * * *") //区间：秒在 0-10 的返回执行
//	@Scheduled(cron = "0/5 * * * * *") //步长：以0秒为基准，步长为5，的时候都执行，即秒为 0，5，10，15...55的时候，都执行
//	@Scheduled(cron = "0/5 * * 25 * *") // ? 解决 日 和 星期冲突的问题，不可能无论星期几都是 25 号，所以，如果日期上写了25，星期可以写成 ? ,解决冲突问题
//	@Scheduled(cron = "0/5 * * W * *")//还可以写上字母L 最后 ，W：工作日

	//复杂定时任务
//	@Scheduled(cron = "0 0/15 14,18 * * ?") //每天14点整，18点整，每隔5分钟执行一次
//	@Scheduled(cron = "0 15 10 ? * 1-6") //每隔月的周一到周六10：15执行
//	@Scheduled(cron = "0 0 2 ? * 6L") //每个月的最后一个周六凌晨两点执行
//	@Scheduled(cron = "0 0 2 LW * ?") //每个月的最后一个工作日凌晨2点执行
//	@Scheduled(cron = "0 0 2-4 ? * 1#1") //每个月的第一个周一凌晨2点到4点期间，每个整点都执行一次
	public void hello() {
		System.out.println("hello...");
	}
}
