package yao.algs.stack;

import yao.algs.array.ResizableArray;

/**
 * 数组实现的栈
 */
@SuppressWarnings("unused")
public class ArrayStack<E> extends ResizableArray<E> {

    public ArrayStack() {
    }

    public void push(E e) {
        add(e);
    }

    public E pop() {
        if (size() == 0) {
            throw new RuntimeException("栈为空，不能继续出栈");
        }
        return remove(size() - 1);
    }

    public E peek() {
        return get(size() - 1);
    }

    /**
     * 查找是否存在元素
     * todo 返回元素距栈顶的距离
     *
     * @param o 元素
     * @return 是否存在
     */
    public boolean search(Object o) {
        return contains(o);
    }

}
