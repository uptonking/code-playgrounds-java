package yao.old.nonlinear.hash;

import java.util.Objects;

/**
 * 哈希表
 */
public class CustomHashtable<K, V> {

    private Entry<K, V>[] table;

    //实际元素数量
    private int count;
    //rehash阈值
    private int threshold;
    //加载因子
    private float loadFactor;

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private static class Entry<K, V> {
        int hash;
        K key;
        V value;
        Entry<K, V> next;

        public Entry() {

        }

        public Entry(int hash, K key, V value, Entry next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            if (value == null)
                throw new NullPointerException();

            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        public boolean equals(Object o) {

            if (!(o instanceof Entry))
                return false;
            Entry<K, V> e = (Entry<K, V>) o;

            return (key == null ? e.getKey() == null : key.equals(e.getKey())) &&
                    (value == null ? e.getValue() == null : value.equals(e.getValue()));
        }

        public int hashCode() {
            return hash ^ Objects.hashCode(value);
        }

        public String toString() {
            return key.toString() + "=" + value.toString();
        }

    }


    public CustomHashtable(int initialCapacity, float loadFactor) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal Load: " + loadFactor);

        if (initialCapacity == 0)
            initialCapacity = 1;
        this.loadFactor = loadFactor;
        table = new Entry[initialCapacity];
        threshold = (int) Math.min(initialCapacity * loadFactor, MAX_ARRAY_SIZE + 1);
    }

    public CustomHashtable(int initialCapacity) {
        this(initialCapacity, 0.75f);
    }

    public CustomHashtable() {
        this(11, 0.75f);
    }

    public synchronized int size() {
        return count;
    }

    public synchronized V put(K key, V value) {
        // Make sure the value is not null
        if (value == null) {
            throw new NullPointerException();
        }

        // Makes sure the key is not already in the hashtable.
        Entry<?, ?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        @SuppressWarnings("unchecked")
        Entry<K, V> entry = (Entry<K, V>) tab[index];
        //当put元素时，如果该索引位置上存在Entry元素，
        //则则遍历该Entry链表
        for (; entry != null; entry = entry.next) {
            if ((entry.hash == hash) && entry.key.equals(key)) {
                V old = entry.value;
                entry.value = value;  //覆盖原来的value
                return old;
            }
        }
        // 当两个不同的key计算出相同的哈希索引，则会发生碰撞。
        // 发生碰撞后，遍历当前索引位置上的entry链表，如果entry节点中key的哈希值想等并且key相等，
        // 就会使用新的value覆盖原来的value。
        // 如果在该索引上没有元素存在，那么添加Entry
        addEntry(hash, key, value, index);
        return null;
    }

    private void addEntry(int hash, K key, V value, int index) {

        Entry<?, ?> tab[] = table;

        //当哈希表中元素的数量大于阀值时，重新设置哈希表的大小
        if (count >= threshold) {
            // Rehash the table if the threshold is exceeded
            rehash();

            tab = table;
            hash = key.hashCode();
            index = (hash & 0x7FFFFFFF) % tab.length;
        }

        // Creates the new entry.
        @SuppressWarnings("unchecked")
        Entry<K, V> e = (Entry<K, V>) tab[index];   //取得哈希索引上的元素，是entry链表上的头结点
        // 把新的节点插入到链表的头结点位置
        tab[index] = new Entry<K, V>(hash, key, value, e);
        count++;
    }


    public synchronized V get(Object key) {
        Entry<?, ?> tab[] = table;
        int hash = key.hashCode();
        int index = (hash & 0x7FFFFFFF) % tab.length;
        for (Entry<?, ?> e = tab[index]; e != null; e = e.next) {
            if ((e.hash == hash) && e.key.equals(key)) {
                return (V) e.value;
            }
        }
        return null;
    }

    protected void rehash() {
        int oldCapacity = table.length;
        Entry<?, ?>[] oldMap = table;

        // overflow-conscious code
        int newCapacity = (oldCapacity << 1) + 1;
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            if (oldCapacity == MAX_ARRAY_SIZE)
                // Keep running with MAX_ARRAY_SIZE buckets
                return;
            newCapacity = MAX_ARRAY_SIZE;
        }


        Entry[] newMap = new Entry[newCapacity];   //初始化新的数组空间，存储Entry

        threshold = (int) Math.min(newCapacity * loadFactor, MAX_ARRAY_SIZE + 1);
        table = newMap;

        for (int i = oldCapacity; i-- > 0; ) {
            for (Entry<K, V> old = (Entry<K, V>) oldMap[i]; old != null; ) {
                Entry<K, V> e = old;
                old = old.next;

                int index = (e.hash & 0x7FFFFFFF) % newCapacity;
                e.next = newMap[index];
                newMap[index] = e;
            }
        }
    }


}
