package tiger.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Slf4j
public class RedisDaoImpl<K, V, HK, HV> implements RedisDao<K, V, HK, HV> {

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean set(K key, V value) {
        try {
            redisTemplate.opsForValue().set(key, value);
        } catch (Exception e) {
            log.error("error", e);
            return false;
        }
        return true;
    }

    @Override
    public boolean hmset(K key, Map<HK, HV> values) {
        redisTemplate.opsForHash().putAll(key, values);
        return false;
    }

    @Override
    public long incr(K key) {
        return redisTemplate.opsForValue().increment(key);
    }

    @Override
    public V get(K key) {
        return (V) redisTemplate.opsForValue().get(key);
    }


}
