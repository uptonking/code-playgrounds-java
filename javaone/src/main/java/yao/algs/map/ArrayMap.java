package yao.algs.map;

import yao.algs.list.TwoWayList;


/**
 * 数组实现的哈希表
 * <p>
 * Created by yaoo on 1/17/18
 */
@SuppressWarnings("unchecked")
public class ArrayMap<K, V> implements IMap<K, V> {

    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75F;

    private Entry<K, V>[] table = null;

    //当前元素个数上界
    private int thresholdMax;
    //负载因子
    private float loadFactor;
    //实际元素个数
    private int size;

    public ArrayMap(int initialCapacity, float loadFactor) {
        this.thresholdMax = initialCapacity;
        this.loadFactor = loadFactor;
        this.table = new Entry[initialCapacity];
    }

    public ArrayMap() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public ArrayMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_LOAD_FACTOR);
    }

    /**
     * 根据键获取值
     *
     * @param key 键
     * @return 值
     */
    @Override
    public V get(Object key) {
        //根据key算出对应的数组下标
        int index = hashKey(key);
        //获取index代表的entry
        Entry<K, V> entry = table[index];

        return getEntryValue(entry, key);
    }

    /**
     * 向map中添加键值
     *
     * @param key   键
     * @param value 值
     * @return 添加的值
     */
    @Override
    public V put(K key, V value) {

        if (size > thresholdMax * loadFactor) {
            resize();
        }

        //根据key算出对应的数组下标
        int index = hashKey(key);
        //获取键值对
        Entry<K, V> entry = table[index];

        ///如果key对应的键值对已存在，出现冲突
        if (entry != null) {

            //如果key相同，则覆盖
            if (entry.key.equals(key)) {
                table[index].setValue(value);
            } else {
                //如果key不同，添加到链表头部
                table[index] = new Entry<>(key, value, entry, index);
            }

        } else {

            //如果key对应的键值对不存在，添加新值到数组
            table[index] = new Entry<>(key, value, null, index);
            size++;
        }

        return table[index].getValue();
    }

    @Override
    public boolean containsKey(Object key) {
        Entry<K, V> curEntry;
        for (int i = 0; i < thresholdMax; i++) {
            curEntry = table[i];

            if (curEntry == null) {
                continue;
            }

            if (curEntry.key.equals(key)) {
                return true;
            }

            curEntry = curEntry.next;

            if (curEntry != null) {
                if (curEntry.key.equals(key)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        Entry<K, V> curEntry;
        for (int i = 0; i < thresholdMax; i++) {
            curEntry = table[i];

            if (curEntry == null) {
                continue;
            }

            if (curEntry.value.equals(value)) {
                return true;
            }

            ///当curEntry非空，且不等于key的时候
            curEntry = curEntry.next;
            if (curEntry != null) {
                if (curEntry.value.equals(value)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public V remove(Object key) {
        Entry<K, V> curEntry;
        V targetValue;
        for (int i = 0; i < thresholdMax; i++) {
            curEntry = table[i];

            if (curEntry == null) {
                continue;
            }

            if (curEntry.key.equals(key)) {
                targetValue = curEntry.value;
                if (curEntry.next == null) {
                    curEntry = null;
                } else {
                    curEntry = curEntry.next;
                }
                return targetValue;
            }

            ///当curEntry非空，且不等于key的时候
            curEntry = curEntry.next;
            if (curEntry != null) {
                if (curEntry.key.equals(key)) {
                    targetValue = curEntry.value;
                    if (curEntry.next == null) {
                        curEntry = null;
                    } else {
                        curEntry = curEntry.next;
                    }
                    return targetValue;
                }
            }
        }


        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        this.thresholdMax = DEFAULT_INITIAL_CAPACITY;
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.table = new Entry[DEFAULT_INITIAL_CAPACITY];
    }

    /**
     * 哈希经典算法之一:取模得到数组下标(会造成大量元素的冲突,有空看看jdk怎么实现的,
     * 它几乎不会产生冲突,也就是说数组中每个链表的长度为1)
     * <p>
     * hashCode的值可能为负数，为避免下标越界，要取绝对值
     * <p>
     * 同一个key hash之后的值要相等
     *
     * @param key 键对象
     * @return 哈希值，整型
     */
    private int hashKey(Object key) {
        int index;

        if (key == null) {
            index = 0;
        } else {
            ///注意：运算符优先级 */% > 移位 > +-
            index = key.hashCode() % thresholdMax / 3 + (key.hashCode() >>> 3) % thresholdMax / 3 + (key.hashCode() >>> 5) % thresholdMax / 3;
        }

        ///备用hash算法
        int h;
        //return key == null ? 0 : ((h = key.hashCode()) ^ (h >> 16));

        return index > 0 ? index : -index;
    }

    /**
     * 递归获取与key一致的entry的value
     *
     * @param entry 键值对
     * @param key   键
     * @return 值
     */
    private V getEntryValue(Entry<K, V> entry, Object key) {

        if (entry == null) return null;

        if (key == entry.getKey() || key.equals(entry.key)) {
            return entry.value;
        }
        return getEntryValue(entry.next, key);
    }


    /**
     * 动态扩容
     * <p>
     * todo 限制容量上界
     */
    private void resize() {
        Entry<K, V>[] newArray = new Entry[thresholdMax * 2];

        TwoWayList<Entry<K, V>> list = new TwoWayList<>();

        ///将所有非空元素加入list
        for (int i = 0; i < thresholdMax; i++) {
            if (table[i] != null) {
                findEntry(table[i], list);
            }
        }

        hashAgain(newArray, list);

    }

    /**
     * 将所有元素重新散列到新数组
     *
     * @param newArray 新数组
     * @param list     存放所有元素的列表
     */
    private void hashAgain(Entry<K, V>[] newArray, TwoWayList<Entry<K, V>> list) {
        size = 0;
        thresholdMax *= 2;
        table = newArray;

        int len = list.size();
        Entry<K, V> entry;
        for (int i = 0; i < len; i++) {
            entry = list.get(i);
            put(entry.key, entry.value);
        }
    }

    /**
     * 递归找出entry，并加入list
     *
     * @param entry     键值对
     * @param entryList 动态链表
     */
    private void findEntry(Entry<K, V> entry, TwoWayList<Entry<K, V>> entryList) {
        entryList.add(entry);

        if (entry.next != null) {
            findEntry(entry.next, entryList);
        }
    }

}

@SuppressWarnings("unchecked")
class Entry<K, V> implements IMap.IEntry<K, V> {

    K key;

    V value;

    //该Entry在数组中的下标
    int index;
    //指向下一个Entry的指针
    Entry<K, V> next;


    Entry(K key, V value, Entry<K, V> next, int index) {
        this.key = key;
        this.value = value;
        this.next = next;
        this.index = index;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
