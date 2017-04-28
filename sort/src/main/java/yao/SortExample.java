//package yao;
//
//import java.io.Console;
//
//public class SortExample {
//
//    /**
//     * 排序的方法
//     * @param a
//     */
//    public static void sort(Comparable[] a) {
//
//    }
//
//    /**
//     * 比较元素的方法，若参数1小于参数2，则返回true
//     * @param v
//     * @param w
//     * @return
//     */
//    private static boolean less(Comparable v, Comparable w) {
//        return v.compareTo(w) < 0;
//    }
//
//    /**
//     * 交换元素的方法
//     * @param a
//     * @param i
//     * @param j
//     */
//    public static void exch(Comparable[] a, int i, int j) {
//        Comparable t = a[i];
//        a[i] = a[j];
//        a[j] = t;
//    }
//
//    /**
//     * 打印元素的方法
//     * @param a
//     */
//    private static void show(Comparable[] a) {
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i] + "");
//        }
//    }
//
//    /**
//     * 判断是否已排序的方法，若上一个小于下一个，则返回true
//     * @param a
//     * @return
//     */
//    private static boolean isSorted(Comparable[] a) {
//
//        for (int i = 1; i < a.length; i++) {
//            if (less(a[i], a[i - 1])) {
//                return false;
//            }
//        }
//
//        return true;
//    }
//
//    public static void main(String[] args) {
//        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        // String str = null;
//        // str = br.readLine();
//        Console console = System.console();
//        String a = console.readLine("请输入待排序数组：");
//        // sort(a);
//        // show(a);
//
//        System.out.println("输入的是：" + a);
//
//    }
//
//}
