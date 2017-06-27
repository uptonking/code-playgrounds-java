package yao.basic.linear.stack;


/**
 * 数组实现的栈
 */
public class ArrayStack<T> {

    //栈顶指针
    private int top;

    private int capacity;

    private int[] array;


    public ArrayStack(int capacity) {
        this.top = -1;
        this.capacity = capacity;
        this.array = new int[this.capacity];
    }

    public ArrayStack() {
        this(1);
    }

    public boolean isEmpty() {


        return true;
    }

    public boolean isFull() {

        return false;
    }

    public int size() {

        return -1;
    }

    public void traverse() {

    }

    public int search() {

        return -1;
    }

    public boolean push(int x) {


        return true;
    }

    public int pop() {

        return -1;
    }

    public int peek() {

        return -1;
    }

    public boolean clear() {

        return true;
    }


    public void display() {

        System.out.println();
    }


}
