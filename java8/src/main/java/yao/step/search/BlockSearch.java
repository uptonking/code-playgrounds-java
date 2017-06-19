package yao.step.search;

/**
 * 分块查找
 * 分块查找是将顺序查找与折半查找相结合的一种查找方法。
 */
public class BlockSearch {

    /**
     * 分块查找，在序列st数组中，用分块查找方法查找关键字为key的记录
     * 块内不必有序，块块之间必须有序
     *
     * @param st    顺序表，
     * @param index 索引表，其中放的是各块的最大值
     * @param key   要查找的值
     * @param m     顺序表中各块的长度相等，为m
     * @return
     */
    public static int searchBlockly(int[] st, int[] index, int key, int m) {

        //1.在index[ ] 中折半查找，确定要查找的key属于哪个块中
//        int i = BinarySearch.searchNonRecursively(index, key, 0, index.length - 1);

        int i = 0;
        while (key > index[i]) {
            i++;
        }

        if (i >= 0) {

            //块中查找的起点
            int j = i > 0 ? i * m : i;
            //块中查找的终点
            int len = (i + 1) * m;

            //2.在确定的块中用顺序查找方法查找key
            for (int k = j; k < len; k++) {
                if (key == st[k]) {
                    //System.out.println("查询成功");
                    return k;
                }
            }
        }

        return -1;
    }


}
