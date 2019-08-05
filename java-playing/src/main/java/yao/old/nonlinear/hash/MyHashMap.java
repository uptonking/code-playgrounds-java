package yao.old.nonlinear.hash;

/**
 * 哈希表
 */
public class MyHashMap<K, V> {

    public class Entry<K, V> {

        //下一个节点
        Entry<K, V> next;
        K key;
        V value;
        //当前键对应的Hash码
        int hash;

        Entry(K k, V v, int hash) {
            this.key = k;
            this.value = v;
            this.hash = hash;
        }
    }

    //默认初始化大小
    private static final int INITIAL_CAPACITY = 8;
    //默认装载因子
    private static final float LOAD_FACTOR = 0.75f;
    //Map大小
    private int size = 0;
    //自定义装载因子
    private float loadFactor;
    //需要扩充容量时的大小
    private int resizeCapacity;
    //存储数据的数组
    private Entry<K, V>[] container;

    //无参构造方法
    public MyHashMap() {
        this(INITIAL_CAPACITY, LOAD_FACTOR);
    }

    //自定义初始化大小构造方法
    public MyHashMap(int initalCapacity) {
        this(initalCapacity, LOAD_FACTOR);
    }

    //完整的构造方法
    public MyHashMap(int initalCapacity, float loadFactor) {
        if (initalCapacity < 0)
            throw new IllegalArgumentException("初始化大小必须为正数:" + initalCapacity);
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("装载因子必须为非负小数:" + loadFactor);
        this.loadFactor = loadFactor;
        //重新设置数组大小的值
        this.resizeCapacity = (int) (loadFactor * initalCapacity);
        this.container = new Entry[initalCapacity];
    }

    /**
     * 扩充Map容量
     */
    private void expand(int newCapacity) {
        //创建一个新数组 大小为 newCapacity
        Entry<K, V>[] newTable = new Entry[newCapacity];
        //初始化 重新设置数组大小的值
        resizeCapacity = (int) (newCapacity * loadFactor);
        Entry<K, V>[] oldTable = container;
        container = newTable;
        //遍历所有元素,全部存储新数组
        for (int i = 0; i < oldTable.length; i++) {
            Entry<K, V> entry = oldTable[i];
            //判断entry是否为空
            while (entry != null) {
                //保存entry 对象链表中的 下一个数据。
                Entry<K, V> e = entry.next;
                //设置
                setEntry(entry, newTable);
                //继续遍历当前index下的链表 直至为null
                entry = e;
            }
        }
        container = newTable;//更改指向为新的数据数组
    }

    /**
     * 将32位的hashcode由高位到低位
     * 每8位进行一次乘法和异或操作
     *
     * @param h
     * @return
     */
    private static int hash(int h) {
        final int p = 16777619;
        int hash = (int) 2166136261L;
        hash = (hash ^ (byte) ((h >> 24) & 0xff)) * p;
        hash = (hash ^ (byte) ((h >> 16) & 0xff)) * p;
        hash = (hash ^ (byte) ((h >> 8) & 0xff)) * p;
        hash = (hash ^ (byte) (h & 0xff)) * p;
        hash = +hash << 13;
        hash ^= hash >> 7;
        hash += hash << 3;
        hash ^= hash >> 17;
        hash += hash << 5;
        return hash;
    }

    /**
     * 计算hash在指定数组的下标
     * 实际是%运算
     *
     * @param hash
     * @return
     */
    private int indexFor(int hash) {
        return hash & (container.length - 1);
    }

    /**
     * 返回map的大小
     */
    public int size() {
        return size;
    }

    /**
     * map为空则返回<code>true</code>
     * 否则返回<code>false</code>
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 是否包含指定的键
     */
    public boolean containsKey(Object key) {
        //不支持为null的键
        if (key == null) {
            throw new NullPointerException("key不能为NULL:");
        }
        //取得数组下标和对应的数据
        int hash = hash(key.hashCode());
        int index = indexFor(hash);
        Entry<K, V> temp = container[index];
        //
        while (temp != null) {
            if (temp.key == key || temp.key.equals(key)) {
                return true;
            } else {
                //不相同遍历下一个
                temp = temp.next;
            }
        }
        return false;
    }

    /**
     * 将指定的节点temp添加到数据数组table的指定下标index中
     *
     * @param temp
     * @param index
     * @param table
     */
    private void setFirstEntry(Entry<K, V> temp, int index, Entry[] table) {
        //如果达到需要扩容的大小
        if (size > resizeCapacity) {
            expand(table.length * 2);
        }
        table[index] = temp;//设置元素
        temp.next = null;//新链表第一个元素
    }

    /**
     * 将元素设置到链表尾部
     *
     * @param entry
     * @param temp
     */
    private void setLastEntry(Entry<K, V> entry, Entry<K, V> temp) {
        if (size > resizeCapacity) {
            expand(container.length * 2);
        }
        entry.next = temp;
    }

    /**
     * 根据key获取value
     */
    public V get(Object key) {
        if (key == null) {
            throw new NullPointerException("key不能为NULL");
        }
        int hash = hash(key.hashCode());
        int index = indexFor(hash);
        Entry<K, V> temp = container[index];
        //判断temp对象是否为null
        while (temp != null) {
            //key相同终止循环
            if (temp.key == key || temp.key.equals(key)) {
                break;
            } else {
                //key不相同继续遍历下一个
                temp = temp.next;
            }
        }
        //如果链表遍历结束还没找到,返回null,否则返回 value
        return temp == null ? null : temp.value;
    }

    /**
     * 存入
     */
    public V put(K key, V value) {
        if (key == null) {
            throw new NullPointerException("key 不能为 NULL");
        }
        //计算key的hashcode
        int hash = hash(key.hashCode());
        //将数据存入Entry
        Entry<K, V> temp = new Entry<K, V>(key, value, hash);
        V v = setEntry(temp, container);
        size++;
        return v;
    }

    /**
     * 删除
     */
    public V remove(Object key) {
        if (key == null) {
            throw new NullPointerException("key 不能为 NULL");
        }
        //取得数组下标和对应的数据
        int hash = hash(key.hashCode());
        int index = indexFor(hash);
        Entry<K, V> temp = container[index];
        //如果不存在返回null
        if (temp == null) {
            return null;
        }
        //如果链表第一个就附和
        if (temp.key == key || temp.key.equals(key)) {
            //设置数组中的下标为temp元素的后继
            container[index] = temp.next;
            return temp.value;
        } else {
            //从链表第一个元素开始遍历
            while (temp != null) {
                //如果和后继元素相同,中断循环
                if (temp.next != null && (temp.key == key || temp.key.equals(key))) {
                    Entry<K, V> e = temp.next;//存储符合条件的元素
                    temp.next = temp.next.next;//设置新的后继元素
                    return e.value;
                } else {
                    temp = temp.next;
                }
            }
        }
        //链表遍历结束没有找到符合的条件返回null
        return null;
    }

    /**
     * 清空map
     */
    public void clear() {
        Entry<K, V>[] table = container;
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
        size = 0;
    }

    public String toString() {
        if (size == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        Entry<K, V>[] table = container;
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                sb.append(table[i].key.toString()).append("=");
                sb.append(table[i].value == null ? "null" : table[i].value.toString()).append(" ");
                //从链表第一个元素开始遍历
                Entry<K, V> temp = table[i].next;
                while (temp != null) {
                    sb.append(temp.key.toString()).append("=");
                    sb.append(temp.value == null ? "null" : temp.value.toString()).append(" ");
                    temp = temp.next;
                }
            }
        }
        return sb.deleteCharAt(sb.length() - 1).append("]").toString();
    }

    /**
     * 将指定的节点temp添加到指定的hash表table当中
     * 如果已经存在并更新了元素的value,则返回更新之前的value,否则返回null
     *
     * @param temp
     * @param table
     * @return
     */
    private V setEntry(Entry<K, V> temp, Entry[] table) {
        //根据hash找到下标
        int index = indexFor(temp.hash);
        //根据下标找到对应的元素
        Entry<K, V> entry = table[index];
        //新存入的值没有后继元素
        temp.next = null;
        //如果entry为null 也就是当前坐标下没有元素时 直接插入元素
        if (entry == null) {
            setFirstEntry(temp, index, table);
            return null;
        }
        //如果entry不为null 也就是当前坐标下具有元素
        while (entry != null) {
            //如果当前坐标下的元素与新元素 key hash相同
            if ((temp.key == entry.key || temp.key.equals(entry.key)) && temp.hash == entry.hash) {
                //两个元素的 value 不同
                if (temp.key == entry.key && temp.value != entry.value) {
                    V v = temp.value;
                    //更新当前坐标下元素的 value
                    entry.value = temp.value;
                    //返回更新前的值
                    return v;
                }
                //如果值相同返回null
                return null;
            } else {
                //else代表当前坐标下具有元素,但是 当前坐标下的元素 和 新元素的 key不一样。也就是产生了冲突。
                if (entry.next == null) {
                    break;//中断循环,防止便利到链表末位的null
                }
                //继续遍历下一个元素
                entry = entry.next;
            }
        }
        //到遍历结束都没有相同的元素,将该元素添加到链表末位
        setLastEntry(entry, temp);
        return null;
    }


}
