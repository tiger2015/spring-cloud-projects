package tiger.dao;

import java.util.Map;

public interface RedisDao<K, V, HK, HV> {

    boolean set(K key, V value);

    boolean hmset(K key, Map<HK, HV> values);

}
