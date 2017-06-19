package yao.step.search;

/**
 * 顺序查找
 */
public class SequentialSearch {

    /**
     * 查找失败返回-1
     *
     * @param a
     * @param key
     * @return
     */
    public static int searchSequentially(int[] a, int key) {

        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i;
            }
        }

        return -1;
    }

    /**
     * 查找失败返回0
     *
     * @param a
     * @param key
     * @return
     */
    public static int searchSequentially2(int[] a, int key) {

        if (a[0] == key) {
            return 0;
        }
        a[0] = key;
        int i = a.length - 1;
        while (a[i] != key) {
            i--;
        }
        return i;
    }


}
