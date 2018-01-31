package com.camille.shaojing.redis;

import java.lang.reflect.Method;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * 通过spring管理redis缓存配置
 * @Cacheable(value="",key="#",condition="#")
 * 用于查询的注解,第一次查询的时候返回该方法返回值,并向redis服务器保存数据。
 * 以后的查询将不再执行方法体内的代码,而是直接查询redis服务器获取数据并返回。
 * @CachePut(value="",key="#",condition="#")
 * 用于新增修改的注解,对其结果进行缓存,每次都会触发真实方法
 * @CacheEvict(value={"",""},key="#",allEntries=true)
 * 根据条件对缓存进行清空
 * 
 */
@Configuration
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {
	private volatile JedisConnectionFactory jedisConnectionFactory;
	private volatile RedisTemplate<String, Object> redisTemplate;
	private volatile RedisCacheManager redisCacheManager;

	public RedisCacheConfig() {
		super();
	}

	/**
	 * 带参数的构造方法 初始化所有的成员变量
	 * 
	 * @param jedisConnectionFactory
	 * @param redisTemplate
	 * @param redisCacheManager
	 */
	public RedisCacheConfig(JedisConnectionFactory jedisConnectionFactory, RedisTemplate<String, Object> redisTemplate,
			RedisCacheManager redisCacheManager) {
		this.jedisConnectionFactory = jedisConnectionFactory;
		this.redisTemplate = redisTemplate;
		this.redisCacheManager = redisCacheManager;
	}

	public JedisConnectionFactory getJedisConnecionFactory() {
		return jedisConnectionFactory;
	}

	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	public RedisCacheManager getRedisCacheManager() {
		return redisCacheManager;
	}

	@Bean
	public KeyGenerator customKeyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object target, Method method, Object... objects) {
				//规定 本类名+方法名+参数名 为key
				StringBuilder sb = new StringBuilder();
				sb.append(target.getClass().getName());
				sb.append(method.getName());
				for (Object obj : objects) {
					sb.append(obj.toString());
				}
				return sb.toString();
			}
		};
	}
}
