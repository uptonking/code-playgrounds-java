package yao.algs.search;

/**
 * 插值查找
 * 插值查找是对二分查找的改进，插值公式为mid = low + (key-a[low])/(a[high]-a[low])*(high-low)
 * 前提条件：有序
 */
public class InsertSearch {

    public static int search(int[] a, int key) {

        return searchNonRecursively(a, key, 0, a.length - 1);
//        return searchRecursively(a, key, 0, a.length - 1);
    }

    /**
     * 查找失败返回-1
     *
     * @param a
     * @param key
     * @param low
     * @param high
     * @return 下标
     */
    public static int searchNonRecursively(int[] a, int key, int low, int high) {

        while (low <= high) {
            int mid = low + (key - a[low]) / (a[high] - a[low]) * (high - low);
            if (key == a[mid]) {
                return mid;
            } else if (key < a[mid]) {
                high = mid - 1;
            } else if (key > a[mid]) {
                low = mid + 1;
            }
        }
        return -1;
    }

//    /**
//     * 查找失败返回-1
//     * @param array
//     * @param key
//     * @param low
//     * @param high
//     * @return
//     */
//    public static int searchRecursively(int[] array, int key, int low, int high) {
//
//        while (low <= high) {
//
//            int mid = (high + low) / 2;
//
//            if (key == array[mid]) {
//                return mid;
//            } else if (key < array[mid]) {
//                return searchRecursively(array, key, low, mid - 1);
//            } else {
//                return searchRecursively(array, key, mid + 1, high);
//            }
//        }
//
//        return -1;
//
//    }


}
