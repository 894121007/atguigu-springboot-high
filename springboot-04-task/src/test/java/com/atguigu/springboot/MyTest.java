package com.atguigu.springboot;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/11/12 15:35
 *
 */
public class MyTest {

	@Test
	public void testPatten() {

		String DATE_STRING = "aabbccdd<><a></a>";
		final String P_COMM = "/<(?:(?:\\/?[A-Za-z]\\w*\\b(?:[=\\s](['\"]?)[\\s\\S]*?\\1)*)|(?:!--[\\s\\S]*?--))\\/?>/g";

		Pattern pattern = Pattern.compile(P_COMM);
		Matcher matcher = pattern.matcher(DATE_STRING);
		System.out.println(matcher.find());
	}
}
