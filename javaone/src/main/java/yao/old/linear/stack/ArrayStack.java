package yao.old.linear.stack;


/**
 * 数组实现的栈
 */
public class ArrayStack<T> {

    //栈顶指针
    private int top;

    private int capacity;

    private T[] array;


    public ArrayStack(int capacity) {
        this.top = -1;
        this.capacity = capacity;
        this.array = (T[]) new Object[this.capacity];
    }

    public ArrayStack() {
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

    public void traverse() {

    }

    public int search() {

        return -1;
    }

    public void push(T item) {
        if (isFull()) {
            System.out.println("栈满溢出！");
        } else {
            top++;
            array[top] = item;
        }
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("栈为空");
            return null;
        } else {
            return array[top--];
        }

    }

    public T peek() {

        return array[top];
    }

    public void clear() {

        top = -1;
    }


    public void display() {

        for (int i = 0; i < capacity; i++) {
            if (i == capacity - 1) {
                System.out.println(array[i]);
            } else {
                System.out.println(array[i] + ", ");
            }
        }

        System.out.println();
    }


}
