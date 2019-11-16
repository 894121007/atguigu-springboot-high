package com.atguigu.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Properties;

/**
 * @author zhanglong
 * @description: 发送高级邮件服务
 * @date 2019/11/11 10:10
 *
 */
@Slf4j
@Service
public class SendHighEmailService {

	@Autowired
	private JavaMailSenderImpl javaMailSender;

	public void sendHighEmail() throws MessagingException, IOException {
//		JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
//		javaMailSender.setUsername("你的邮箱地址");
//		javaMailSender.setPassword("你的邮箱AUTH密码,不是登陆密码哦,在邮箱的设置里单独开启和设置");
//		javaMailSender.setHost("smtp.exmail.qq.com");
//		javaMailSender.setPort(587);
//		javaMailSender.setDefaultEncoding("UTF-8");
		Properties props = new Properties();
		props.setProperty("mail.smtp.host", "smtp.exmail.qq.com");
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.smtp.connectiontimeout", "20000");
		props.setProperty("mail.smtp.timeout", "20000");
		javaMailSender.setJavaMailProperties(props);

		MimeMessage message = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");
		helper.setTo("zhanglong_xinhua@163.com");
//		helper.setCc("抄送人邮箱");
		helper.setFrom("894121007@qq.com");
		helper.setSubject("liang subject");
		helper.setText(buildContent(), true);


		String alarmIconName = "ok.png";
		ClassPathResource img = new ClassPathResource("/static/highemail/" + alarmIconName);
		if (Objects.nonNull(img)) {
			helper.addInline("icon-alarm", img);
		}
		javaMailSender.send(message);
	}


	private static String buildContent() throws IOException {

		//加载邮件html模板
		String fileName = "pod-scale-alarm.html";
//		InputStream inputStream = SendHighEmailService.class.getResourceAsStream("/static/highemail/" + fileName);
		InputStream inputStream = ClassLoader.getSystemResourceAsStream("static/highemail/" + fileName);
		BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputStream));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		try {
			while ((line = fileReader.readLine()) != null) {
				buffer.append(line);
			}
		} catch (Exception e) {
			log.error("读取文件失败，fileName:{}", fileName, e);
		} finally {
			inputStream.close();
			fileReader.close();
		}


		String contentText = "以下是服务实例伸缩信息, 敬请查看.<br>below is the information of service instance scale, please check. ";
		//邮件表格header
		String header = "<td>分区(Namespace)</td><td>服务(Service)</td><td>伸缩结果(Scale Result)</td><td>伸缩原因(Scale Reason)</td><td>当前实例数(Pod instance number)</td>";
		StringBuilder linesBuffer = new StringBuilder();
		linesBuffer.append("<tr><td>" + "myNamespace" + "</td><td>" + "myServiceName" + "</td><td>" + "myscaleResult" + "</td>" +
				"<td>" + "mReason" + "</td><td>" + "my4" + "</td></tr>");

		//绿色
		String emailHeadColor = "#10fa81";
		String date = DateFormatUtils.format(new Date(), "yyyy/MM/dd HH:mm:ss");
		//填充html模板中的五个参数
		String htmlText = MessageFormat.format(buffer.toString(), emailHeadColor, contentText, date, header, linesBuffer.toString());

		//改变表格样式
		htmlText = htmlText.replaceAll("<td>", "<td style=\"padding:6px 10px; line-height: 150%;\">");
		htmlText = htmlText.replaceAll("<tr>", "<tr style=\"border-bottom: 1px solid #eee; color:#666;\">");
		return htmlText;
	}
}
