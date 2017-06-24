package yao.basic.linear.stack;

import yao.basic.linear.array.Array;

/**
 * Java栈
 */
public class ArrayStack {

    private int top;

    private int capacity;

    private int[] array;

    public ArrayStack(){
        this.top = -1;
        this.capacity=1;
        this.array = new int[this.capacity];
    }

    public ArrayStack(int capacity){
        this.top = -1;
        this.capacity=capacity;
        this.array = new int[this.capacity];
    }

    public boolean isEmpty(){


        return true;
    }

    public boolean isFull(){

        return false;
    }

    public int size(){

        return -1;
    }

    public boolean push(int x){


        return true;
    }

    public int pop(){

        return -1;
    }

    public int peek(){

        return -1;
    }

    public boolean clear(){

        return true;
    }

    public boolean search(Object o){

        return true;
    }



    public void display(){

        System.out.println("");
    }



}
