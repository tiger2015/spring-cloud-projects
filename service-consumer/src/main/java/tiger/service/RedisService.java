package tiger.service;

public interface RedisService<K, V, HK, HV> {

    boolean save(K key, V value);
}
