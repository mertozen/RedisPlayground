package io.redis.jedis.jedisdemo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Component;

import io.redis.jedis.jedisdemo.model.Programmer;

@Component
public class RedisConfig {

	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		// template.setKeySerializer(new StringRedisSerializer());
		return redisTemplate;
	}

	@Bean
	public RedisTemplate<String, Programmer> redisProgrammerTemplate() {
		RedisTemplate<String, Programmer> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		// template.setKeySerializer(new StringRedisSerializer());
		return redisTemplate;
	}

	@Bean
	@Qualifier("listOperations")
	public ListOperations<String, Programmer> listOperations(
			RedisTemplate<String, Programmer> redisProgrammerTemplate) {

		return redisProgrammerTemplate.opsForList();
	}

	@Bean
	@Qualifier("setOperations")
	public SetOperations<String, Programmer> setOperations(RedisTemplate<String, Programmer> redisProgrammerTemplate) {

		return redisProgrammerTemplate.opsForSet();
	}

	@Bean
	@Qualifier("hashOperations")
	public HashOperations<String, Integer, Programmer> hashOperations(RedisTemplate<String, Object> redisTemplate) {

		return redisTemplate.opsForHash();
	}

}
