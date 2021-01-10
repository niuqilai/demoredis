package org.atech.portal.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.time.Duration;

@Component
@Configuration
public class RedisConfig extends CachingConfigurerSupport {
    private Logger logger = LoggerFactory.getLogger(RedisConfig.class);


    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.port}")
    private int port;
    @Value("${spring.redis.timeout}")
    private int timeout;


    @Value("${spring.redis.pool.maxActive}")
    private int maxActive;
    @Value("${spring.redis.pool.maxIdle}")
    private int maxIdle;
    @Value("${spring.redis.pool.minIdle}")
    private int minIdle;
    @Value("${spring.redis.pool.maxWaitMillis}")
    private long maxWaitMillis;
    @Value("${spring.redis.pool.testOnBorrow}")
    private boolean testOnBorrow;


    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(maxActive);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMinIdle(minIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        jedisPoolConfig.setTestOnBorrow(testOnBorrow);

        return jedisPoolConfig;
    }

    @Bean
    public JedisPool jedisPool(JedisPoolConfig jedisPoolConfig) {

        System.out.println("=====创建JedisPool连接池=====");
        if(StringUtils.isNotEmpty(password)) {
            return new JedisPool(jedisPoolConfig, host, port, timeout, password);
        }

        return new JedisPool(jedisPoolConfig, host, port, timeout);
    }

//    @Bean
//    public CacheManager cacheManager(RedisConnectionFactory factory) {
//        //对象的序列化
//        RedisSerializationContext.SerializationPair valueSerializationPair
//                = RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer());
//        //全局redis缓存过期时间
//        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
//                .entryTtl(Duration.ofHours(1L))
////                .serializeKeysWith()
//                .serializeValuesWith(valueSerializationPair);
//
//        return new RedisCacheManager(RedisCacheWriter.nonLockingRedisCacheWriter(factory), redisCacheConfiguration);
//    }

//    private Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer() {
//        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
//        jackson2JsonRedisSerializer.setObjectMapper(objectMapper());
//        return jackson2JsonRedisSerializer;
//    }
//
//    private ObjectMapper objectMapper() {
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//        return objectMapper;
//    }



}
