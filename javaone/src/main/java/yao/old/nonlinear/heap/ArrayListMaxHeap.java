package yao.old.nonlinear.heap;

import java.util.ArrayList;

public class ArrayListMaxHeap<E extends Comparable> {

    //用ArrayList实现堆
    private ArrayList<E> list = new ArrayList<>();

    public ArrayListMaxHeap() {
    }

    public ArrayListMaxHeap(E[] objects) {
        for (int i = 0; i < objects.length; i++) {
            add(objects[i]);
        }
    }

    public void add(E newObject) {//添加一个元素
        list.add(newObject);
        int currentIndex = list.size() - 1;

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;//找到该结点的父结点
            if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0) {//与父节点比较
                //如果当前结点的值大于父结点就交换位置
                E temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            } else
                break;
            currentIndex = parentIndex;
        }
    }

    public E remove() {//删除并返回根结点,堆的特点是移除了根结点后还是堆
        if (list.size() == 0) return null;

        E removeObject = list.get(0);
        list.set(0, list.get(list.size() - 1));//把最后一个结点放在根结点的位置
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while (currentIndex < list.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;//左右孩子结点的坐标

            if (leftChildIndex >= list.size()) break;
            //比较左右孩子的值，使maxIndex指向值大的结点
            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
                    maxIndex = rightChildIndex;
                }
            }
            //如果当前结点的值小于其左右孩子中的大的值，就交换两个结点
            if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            } else
                break;
        }

        return removeObject;

    }

    public int getSize() {
        return list.size();
    }

}
