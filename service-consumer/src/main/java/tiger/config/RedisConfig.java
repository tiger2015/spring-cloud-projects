package tiger.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
@ConfigurationProperties
@Slf4j
public class RedisConfig {

    @Value("${redis.port}")
    private int port;
    @Value("${redis.host}")
    private String host;
    @Value("${redis.password}")
    private String password;

    @Value("${redis.pool.maxTotal}")
    private int maxTotal;
    @Value("${redis.pool.maxIdle}")
    private int maxIdle;
    @Value("${redis.pool.minIdle}")
    private int minIdle;
    @Value("${redis.pool.maxWaitMills}")
    private long maxWaitMills;

    @Value("${redis.key.serializer:org.springframework.data.redis.serializer.StringRedisSerializer}")
    private String redisKeySerializer;
    @Value("${redis.value.serializer}")
    private String redisValueSerializer;
    @Value("${redis.hash.key.serializer:org.springframework.data.redis.serializer.StringRedisSerializer}")
    private String redisHashKeySerializer;
    @Value("${redis.hash.value.serializer}")
    private String redisHashValueSerializer;




    private RedisStandaloneConfiguration redisStandaloneConfiguration() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(host);
        log.info("host:"+host);
        redisStandaloneConfiguration.setPassword(RedisPassword.of(password));
        redisStandaloneConfiguration.setPort(port);
        return redisStandaloneConfiguration;
    }

    private GenericObjectPoolConfig poolConfig() {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxIdle(maxIdle);
        poolConfig.setMinIdle(minIdle);
        poolConfig.setMaxTotal(maxTotal);
        poolConfig.setMaxWaitMillis(maxWaitMills);
        return poolConfig;
    }

    private LettuceConnectionFactory connectionFactory() {
        LettucePoolingClientConfiguration.LettucePoolingClientConfigurationBuilder builder = LettucePoolingClientConfiguration.builder();
        builder.poolConfig(poolConfig());
        LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration(), builder.build());
        connectionFactory.afterPropertiesSet();
        return connectionFactory;
    }


    @Bean
    public RedisTemplate redisTemplate() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(connectionFactory());
        redisTemplate.setKeySerializer((RedisSerializer<?>) Class.forName(redisKeySerializer).newInstance());
        if(redisValueSerializer != null){
            redisTemplate.setValueSerializer((RedisSerializer<?>) Class.forName(redisValueSerializer).newInstance());
        }
        redisTemplate.setHashKeySerializer((RedisSerializer<?>) Class.forName(redisHashKeySerializer).newInstance());
        if(redisHashValueSerializer!=null){
            redisTemplate.setHashValueSerializer((RedisSerializer<?>) Class.forName(redisHashValueSerializer).newInstance());
        }
        redisTemplate.afterPropertiesSet();
        log.info("create redisTemplate");
        return redisTemplate;
    }
}
