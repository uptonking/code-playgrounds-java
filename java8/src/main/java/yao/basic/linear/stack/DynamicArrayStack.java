package yao.basic.linear.stack;

/**
 * 数组实现的可动态扩容的栈
 */
public class DynamicArrayStack<T> {

    private int top;
    private int capacity;
    private T[] array;

    public DynamicArrayStack(int capacity) {
        this.top = -1;
        this.capacity = capacity;
        this.array = (T[]) new Object[this.capacity];
    }

    public DynamicArrayStack() {
        this(1);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == (capacity - 1);
    }

    public int size() {
        return top + 1;
    }


    public void push(T data) {
        if (isFull()) {
            doubleStack();
        }
        top++;
        array[top] = data;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("栈满溢出");
            return null;
        }
        return array[top--];
    }

    public void doubleStack() {
        T[] newArray = (T[]) new Object[2 * capacity];
        System.arraycopy(array, 0, newArray, 0, capacity);
        capacity *= 2;
        array = newArray;
    }

    public void clear() {
        top = -1;
    }

}
