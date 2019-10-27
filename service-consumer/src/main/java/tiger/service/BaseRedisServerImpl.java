package tiger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.dao.RedisDao;

import java.util.Map;

@Service
public class BaseRedisServerImpl<K, V, HK, HV> implements BaseRedisService<K, V, HK, HV> {
    @Autowired
    private RedisDao<K, V, HK, HV> redisDao;

    @Override
    public boolean save(K key, V value) {
        redisDao.set(key, value);
        return false;
    }

    @Override
    public boolean saveHash(K key, Map<HK, HV> map) {
        redisDao.hmset(key, map);
        return false;
    }

    @Override
    public V get(K key) {
        return redisDao.get(key);
    }

    @Override
    public long incrAndGet(K key) {
        return redisDao.incr(key);
    }
}
