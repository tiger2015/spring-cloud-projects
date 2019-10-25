package tiger.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.dao.RedisDao;

@Service
public class RedisServerImpl<K, V, HK, HV> implements RedisService<K, V, HK, HV> {
    @Autowired
    private RedisDao<K, V, HK, HV> redisDao;

    @Override
    public boolean save(K key, V value) {
        redisDao.set(key, value);
        return false;
    }
}
