package tiger.service;

import java.util.Map;

public interface BaseRedisService<K, V, HK, HV> {

    boolean save(K key, V value);

    boolean saveHash(K key, Map<HK, HV> map);

    V get(K key);
}
