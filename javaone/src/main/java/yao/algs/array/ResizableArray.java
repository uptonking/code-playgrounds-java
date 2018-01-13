package yao.algs.array;

import yao.algs.AbstractCollection;

import java.util.Arrays;

/**
 * Java实现的动态数组，类似于ArrayList
 * 限制：加入的元素不能是null
 * Created by yaoo on 1/10/18
 */
@SuppressWarnings("unused")
public class ResizableArray<E> extends AbstractCollection<E> {

    //默认分配的初始大小
    private static final int DEFAULT_CAPACITY = 16;
    //默认最多元素个数，保留8个
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;
    //通用的空数组
    private static final Object[] EMPTY_ELEMENTDATA = {};
    //默认元素个数
    private int size;
    //存储数据的数组
    private Object[] elementData;


    public ResizableArray() {
        this.elementData = EMPTY_ELEMENTDATA;
    }

    public ResizableArray(int initialCapacity) {
        if (initialCapacity > 0 && initialCapacity <= MAX_ARRAY_SIZE) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new RuntimeException("初始化大小 " + initialCapacity + " 不能为负数，且不能大于2^31-9");
        }
    }


    public E get(int index) {
        checkRange(index);
        return elementData(index);
    }

    public E set(int index, E ele) {
        checkRange(index);
        E oldValue = elementData(index);
        elementData[index] = ele;
        return oldValue;
    }

    @SuppressWarnings("unchecked")
    private E elementData(int index) {
        return (E) elementData[index];
    }

    /**
     * 加入元素到末尾
     *
     * @param e 元素
     * @return 插入成功/失败
     */
    @Override
    public boolean add(E e) {
        ensureElementNotNull(e);
        ensureCapacity(size + 1);
        elementData[size++] = e;
        return true;
    }

    /**
     * 插入元素到指定位置index
     *
     * @param index 位置，第1个为0
     * @param e     待插入元素
     * @return 插入成功/失败
     */
    public boolean add(int index, E e) {
        ensureElementNotNull(e);

        ensureCapacity(size + 1);

        checkRange(index);

        System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        elementData[index] = e;
        size++;
        return true;
    }

    /**
     * 删除指定位置的元素
     *
     * @param index 位置，从0开始
     * @return 删除的元素
     */
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        checkRange(index);

        E ele = (E) elementData[index];
        System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        elementData[--size] = null;
        return ele;
    }

    /**
     * 删除第一次出现的指定元素
     *
     * @param o 元素
     * @return 删除的元素
     */
    @Override
    @SuppressWarnings("unchecked")
    public boolean remove(Object o) {

        ensureElementNotNull(o);

        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) {
                System.arraycopy(elementData, i + 1, elementData, i, size - i - 1);
                size--;
                return true;
            }
        }

        return false;
    }

    @Override
    public void clear() {

        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] t) {
        return (T[]) trimToSize();
    }

    private Object[] trimToSize() {
        if (size < elementData.length) {
            elementData = (size == 0) ? EMPTY_ELEMENTDATA : Arrays.copyOf(elementData, size);
        }
        return elementData;
    }

    @Override
    public String toString() {
        return Arrays.toString(toArray(new Object[size]));
    }

    /**
     * 数组动态扩容方法，每次增加现有长度的一半
     */
    private void grow() {
        int oldCapacity = elementData.length;
        if (oldCapacity == MAX_ARRAY_SIZE) {
            throw new RuntimeException("已达到最大长度2^31-9，不能再加入元素");
        }

        int newCapacity = oldCapacity == 0 ? DEFAULT_CAPACITY : (oldCapacity + (oldCapacity >> 1));
        if (newCapacity > MAX_ARRAY_SIZE) {
            newCapacity = MAX_ARRAY_SIZE;
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    /**
     * 判断是否需要扩容
     * todo reminder 是否要加入负载因子
     * 当元素个数达到数组长度时，动态扩容
     *
     * @param eleSize 新的元素个数
     */
    private void ensureCapacity(int eleSize) {
        if (elementData.length < DEFAULT_CAPACITY) {
            elementData = Arrays.copyOf(elementData, DEFAULT_CAPACITY);
            return;
        }

        ///倒数第2个元素扩容，数组长10，插入第9个元素时判断应该扩容
        if (eleSize > elementData.length - 1) {
            grow();
        }
    }

    private void ensureElementNotNull(Object o) {
        if (o == null) {
            throw new RuntimeException("元素不能是null");
        }
    }

    private void checkRange(int index) {
        if (index < 0 || index >= size)
            throw new RuntimeException(index + " 插入的位置越界或不合法");
    }

}
