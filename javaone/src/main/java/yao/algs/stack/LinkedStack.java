package yao.algs.stack;

import yao.algs.list.TwoWayList;

/**
 * 双向链表实现的栈
 * <p>
 * 依赖于双向链表类
 */
@SuppressWarnings("unused")
public class LinkedStack<E> extends TwoWayList<E> {

    public LinkedStack() {
    }

    public void push(E e) {
        addLast(e);
    }

    public E pop() {
        if (size() == 0) {
            throw new RuntimeException("栈为空，不能继续出栈");
        }
        return removeLast();
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
