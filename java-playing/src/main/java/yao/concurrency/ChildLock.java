package yao.concurrency;

/**
 * synchronized也是可重入的，不会阻塞
 */
public class ChildLock extends Father {


    public synchronized void doSomething() {
        System.out.println("child.doSomething()");
        doAnotherThing(); // 调用自己类中其他的synchronized方法

    }

    private synchronized void doAnotherThing() {
        super.doSomething(); // 调用父类的synchronized方法
        System.out.println("child.doAnotherThing()");
    }

    public static void main(String[] args) {
        ChildLock child = new ChildLock();
        child.doSomething();
    }

}

class Father {
    public synchronized void doSomething() {
        System.out.println("father.doSomething()");
    }

}
