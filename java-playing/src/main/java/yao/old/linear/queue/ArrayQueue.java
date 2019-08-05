package yao.old.linear.queue;

import java.util.Arrays;

/**
 * 数组实现的顺序循环队列
 * 简单的顺序队列会出现假溢出+浪费空间
 * 缺点：实现队列的数组length必须先声明，且不变
 */
public class ArrayQueue<T> {

    //指向队首元素
    private int front;
    //指向队尾元素的下一个元素
    private int rear;
    //队列元素个数为capacity-1
    private int capacity;
    private T[] array;

    public ArrayQueue(int capacity) {
        front = rear = 0;

        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
    }

    public ArrayQueue(int capacity, T item) {
        front = rear = 0;
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
        array[0] = item;
        rear++;
    }

    public ArrayQueue() {
        this(10);
    }


    //队空条件
    public boolean isEmpty() {
//        return front == rear && array[rear] == null;
        return front == rear;
    }

    //队满条件，保留一个元素的存储空间
    public boolean isFull() {
        return (rear + 1) % capacity == front;
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        int size = 0;
        size = rear > front ? rear - front : capacity - (front - rear);
        return size;
    }

    public void traverse() {

    }

    public void search() {

    }

    public void enQueue(T item) {
        if (isFull()) {
//            System.out.println("队列已满，元素溢出！");
            resizeCapacity();
        }
        array[rear] = item;
        rear = (rear + 1) % capacity;
    }

    public T deQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，无元素出队！");
            return null;
        }

        T item = array[front];
        front = (front + 1) % capacity;
        return item;
    }

    public T[] reverse() {

        return null;
    }

    public void clear() {
        Arrays.fill(array, 0);
        front = rear = 0;
    }

    public void display() {

        System.out.println();
    }

    public void resizeCapacity(int rate) {

        ///队列元素按顺序复制到新数组
        int initCapacity = capacity;
        capacity *= rate;
        T[] newArray = (T[]) new Object[capacity];
        System.arraycopy(array, 0, newArray, 0, capacity);
        array = newArray;

        ///队列发生循环时，调整顺序
        if (rear < front) {
            for (int i = 0; i < front; i++) {
                array[i + initCapacity] = array[i];
                array[i] = null;
            }
            rear = rear + initCapacity;
        }

    }

    public void resizeCapacity() {
        resizeCapacity(2);
    }


}
