package com.atguigu.springboot.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/25 17:59
 *
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
	protected void configure(HttpSecurity http) throws Exception {
		//定制请求的授权规则
		http
				.authorizeRequests().antMatchers("/").permitAll()
				.antMatchers("/level1/**").hasRole("VIP1")
				.antMatchers("/level2/**").hasRole("VIP2")
				.antMatchers("/level3/**").hasRole("VIP3");
		//开启自动配置的登录场景，效果，如果没有登录，没有授权就会来到登录页面
		/**
		 * The most basic configuration defaults to automatically generating a login page at
		 * the URL "/login", redirecting to "/login?error" for authentication failure. The
		 * details of the login page can be found on
		 *
		 * 1、/login来到spring security 的登录页
		 * 2、重定向到/login?error表示登录失败
		 * 3、更多详细的规定可以浏览方法的注释
		 */
		http.formLogin()
				.loginPage("/userlogin")
				.loginProcessingUrl("/login");
//		http.formLogin();

		/**
		 * Provides logout support. This is automatically applied when using
		 * {@link WebSecurityConfigurerAdapter}. The default is that accessing the URL
		 * "/logout" will log the user out by invalidating the HTTP Session, cleaning up any
		 * {@link #rememberMe()} authentication that was configured, clearing the
		 * {@link SecurityContextHolder}, and then redirect to "/login?success".
		 *
		 */
		http.logout().logoutSuccessUrl("/");

		http.rememberMe();

	}

	/**
	 * 认证方法
	 * 添加登录用户，并且为登录用户添加权限
	 */
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		String encode = passwordEncoder.encode("123456");
		auth.inMemoryAuthentication()
				.withUser("zhangsan").password(encode).roles("VIP1","VIP2")
				.and()
				.withUser("lisi").password(encode).roles("VIP2","VIP3")
				.and()
				.withUser("wangwu").password(encode).roles("VIP1","VIP3");
	}
}
