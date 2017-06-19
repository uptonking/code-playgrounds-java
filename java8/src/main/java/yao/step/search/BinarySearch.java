package yao.step.search;

/**
 * 二分查找
 * 二分查找法是对一组有序的数字中进行查找，传递相应的数据，进行比较查找到与原数据相同的数据，查找到了返回1，失败返回对应的数组下标。
 */
public class BinarySearch {

    public static int search(int[] a, int key) {
        return searchNonRecursively(a, key, 0, a.length - 1);
//        return searchRecursively(a, key, 0, a.length - 1);
    }

    /**
     * 查找失败返回-1
     * @param array
     * @param key
     * @param low
     * @param high
     * @return
     */
    public static int searchNonRecursively(int[] array, int key, int low, int high) {

        while (low <= high) {
            int mid = (high + low) / 2;
            if (key == array[mid]) {
                return mid;
            } else if (key < array[mid]) {
                high = mid - 1;
            } else if (key > array[mid]) {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找失败返回-1
     * @param array
     * @param key
     * @param low
     * @param high
     * @return
     */
    public static int searchRecursively(int[] array, int key, int low, int high) {

        while (low <= high) {

            int mid = (high + low) / 2;

            if (key == array[mid]) {
                return mid;
            } else if (key < array[mid]) {
                return searchRecursively(array, key, low, mid - 1);
            } else {
                return searchRecursively(array, key, mid + 1, high);
            }
        }

        return -1;

    }


}
