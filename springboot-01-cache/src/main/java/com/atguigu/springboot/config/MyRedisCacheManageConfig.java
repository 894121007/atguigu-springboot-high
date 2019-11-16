package com.atguigu.springboot.config;

import com.atguigu.springboot.bean.Department;
import com.atguigu.springboot.bean.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

/**
 * @author zhanglong
 * @description: TODO
 * @date 2019/7/19 15:22
 *
 */
@Configuration
@EnableConfigurationProperties(CacheProperties.class)
public class MyRedisCacheManageConfig {

	@Autowired
	private CacheProperties cacheProperties;

	//如果不指定具体选择哪个CacheManager，就使用默认序列化的，这样的化，虽然在redis中是二进制，
	// 但是序列化和反序列化都能成功
	@Bean
	@Primary
	public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
		RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.builder(redisConnectionFactory)
				.cacheDefaults(determineConfiguration());
		return builder.build();
	}

	@Bean
	public RedisCacheManager deptCacheManager(RedisConnectionFactory redisConnectionFactory) {
		RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.builder(redisConnectionFactory)
				.cacheDefaults(deptDetermineConfiguration());
		return builder.build();
	}

	@Bean
	public RedisCacheManager empCacheManager(RedisConnectionFactory redisConnectionFactory) {
		RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.builder(redisConnectionFactory)
				.cacheDefaults(empDetermineConfiguration());
		return builder.build();
	}

	private org.springframework.data.redis.cache.RedisCacheConfiguration deptDetermineConfiguration() {
		org.springframework.data.redis.cache.RedisCacheConfiguration config = org.springframework.data.redis.cache.RedisCacheConfiguration
				.defaultCacheConfig();
		config = config.serializeValuesWith(
				RedisSerializationContext.SerializationPair.fromSerializer(new Jackson2JsonRedisSerializer<Department>(Department.class)));
		return config;
	}

	private org.springframework.data.redis.cache.RedisCacheConfiguration empDetermineConfiguration() {
		org.springframework.data.redis.cache.RedisCacheConfiguration config = org.springframework.data.redis.cache.RedisCacheConfiguration
				.defaultCacheConfig();
		config = config.serializeValuesWith(
				RedisSerializationContext.SerializationPair.fromSerializer(new Jackson2JsonRedisSerializer<Employee>(Employee.class)));
		return config;
	}

	private org.springframework.data.redis.cache.RedisCacheConfiguration determineConfiguration() {
		org.springframework.data.redis.cache.RedisCacheConfiguration config = org.springframework.data.redis.cache.RedisCacheConfiguration
				.defaultCacheConfig();
		config = config.serializeValuesWith(
				RedisSerializationContext.SerializationPair.fromSerializer(new JdkSerializationRedisSerializer()));
		return config;
	}
}
