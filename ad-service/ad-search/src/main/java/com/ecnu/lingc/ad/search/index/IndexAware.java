package com.ecnu.lingc.ad.search.index;

/**
 * @program: fresh-ad-system
 * @Date: 2019/7/4 21:02
 * @Author: Ling Chen
 * @Description:
 */
public interface IndexAware<K, V> {
    V get(K key);

    void add(K key, V value);

    void update(K key, V value);

    void delete(K key, V value);
}
