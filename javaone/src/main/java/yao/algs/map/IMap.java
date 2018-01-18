package yao.algs.map;

/**
 * 哈希表接口
 * <p>
 * Created by yaoo on 1/17/18
 */
public interface IMap<K, V> {

    V get(Object key);

    V put(K key, V value);

    boolean containsKey(Object key);

    boolean containsValue(Object value);

    boolean isEmpty();


    V remove(Object key);

    int size();

    void clear();

    interface IEntry<K, V> {
        K getKey();

        V getValue();
    }


}
