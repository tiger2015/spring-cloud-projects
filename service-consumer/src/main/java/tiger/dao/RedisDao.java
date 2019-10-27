package tiger.dao;

import java.util.Map;

public interface RedisDao<K, V, HK, HV> {

    boolean set(K key, V value);

    V get(K key);

    boolean hmset(K key, Map<HK, HV> values);

    long incr(K key);


}
