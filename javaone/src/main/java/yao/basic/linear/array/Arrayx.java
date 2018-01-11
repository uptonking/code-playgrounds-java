package yao.basic.linear.array;

/**
 * Java不需要自定义数组
 * 基本类型数组直接使用
 * 引用类型数组要注意初始化
 * <p>
 * 自定义数组类可加入过滤、排序、连接等常用工具类的功能
 */
public class Arrayx {

    //数组对象，元素为整型
    private int[] arr;
    //数组最大长度
    private int arrSize;
    //数组非空数据长度
    public int length;

    public Arrayx(int size) {
        if (size <= 0) {
            System.out.println("invalid array size");
            return;
        }
        arrSize = size;
        length = 0;
        getArray();
    }

    private void getArray() {
        arr = new int[arrSize];
        if (arr == null) {
            System.out.println("memory allocation error");
        }
    }

    /**
     * 获取下标为i的元素
     *
     * @param i
     * @return
     */
    public int get(int i) {
        return (i < 0 || i > length - 1) ? null : arr[i];
    }


    public void traverse() {

        for (int i = 0; i < length; i++) {
            System.out.println(arr[i] + "  ");
        }
    }

    /**
     * 获取值为x的第一个元素的下标，查找失败返回-1
     *
     * @param x
     * @return
     */
    public int search(int x) {
        for (int i = 0; i < length; i++) {
            if (x == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 在下标i插入新值x
     *
     * @param x
     * @param i
     * @return
     */
    public boolean add(int x, int i) {
        if (length == arrSize) {
            System.out.println("array size overflow");
            return false;
        } else if (i < 0 || i > length) {
            System.out.println("add position error");
            return false;
        } else {
            for (int j = length - 1; j > i; j--) {
                arr[j + 1] = arr[j];
            }
            arr[i] = x;
            length++;
            return true;
        }
    }

    /**
     * 在末位插入新值x
     *
     * @param x
     * @return
     */
    public boolean add(int x) {
        if (length == arrSize) {
            System.out.println("array size overflow");
            return false;
        } else {
            arr[length] = x;
            length++;
            return true;
        }
    }


    /**
     * 移除下标i的值
     *
     * @param i
     * @return
     */
    public boolean remove(int i) {
        if (length == 0) {
            System.out.println("array is empty, no remove");
            return false;
        } else if (i < 0 || i > length - 1) {
            System.out.println("remove position error");
            return false;
        } else {
            for (int j = i; j < length - 1; j++) {
                arr[j] = arr[j + 1];
            }
            length--;
            return true;
        }
    }

    /**
     * 两数组合并，b并入a，去重复
     *
     * @param a
     * @param b
     */
    public void union(Arrayx a, Arrayx b) {
        int al = a.length;
        int bl = b.length;

        for (int i = 0; i < bl; i++) {
            int x = b.get(i);
            int k = a.search(x);
            if (k == -1) {
                a.add(x, al);
                al++;
            }
        }
    }

    /**
     * 两数组求交，相同元素放入a，去重复
     *
     * @param a
     * @param b
     */
    public void intersection(Arrayx a, Arrayx b) {
        int al = a.length;
        int bl = b.length;

        for (int i = 0; i < al; ) {
            int x = a.get(i);
            int k = b.search(x);
            if (k == -1) {
                a.remove(i);
                al--;
            } else {
                i++;
            }

        }
    }

    public void clear() {
        arr = null;
        length = 0;
    }


    /**
     * 数组打印
     */
    public void display() {
        StringBuilder result = new StringBuilder();

        if (arr == null) {
            result.append("null");

        } else if (length == 0) {
            result.append("[]");
        } else {
            result.append("[");
            for (int i = 0; i < length; i++) {
                if (i == length - 1) {
                    result.append(arr[i]).append("]");
                } else {

                    result.append(arr[i]).append(", ");
                }
            }
        }

        System.out.println(result);
    }

}
