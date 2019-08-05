package yao.string;

/**
 * 字符串匹配
 */
public class StringMatch {

    /**
     * 暴力匹配
     * 模式字符串相对于源字符串每次右移1位
     *
     * @param strS
     * @param strP
     * @return
     */
    public int matchViolently(String strS, String strP) {

        char[] s = strS.toCharArray();
        char[] p = strP.toCharArray();
        int sLen = s.length;
        int pLen = p.length;

        int i = 0, j = 0;
        while (i < sLen && j < pLen) {
            if (s[i] == p[j]) {
                ///如果字符相同，都后移一位
                i++;
                j++;
            } else {
                ///如果字符不同，s后移1位，p回到头部
                i = i - j + 1;
                j = 0;
            }
        }

        if (j == pLen) {
            return i - j;
        } else {
            return -1;
        }
    }

    /**
     * Knuth-Morris-Pratt 字符串查找算法
     * 模式字符串相对于源字符串每次右移j-next[j]位
     *
     * @param strS
     * @param strP
     * @return
     */
    public int matchKMP(String strS, String strP) {
        char[] s = strS.toCharArray();
        char[] p = strP.toCharArray();
        int sLen = s.length;
        int pLen = p.length;

        int[] next = getNext(p);

        int i = 0, j = 0;
        while (i < sLen && j < pLen) {
            if (j == -1 || s[i] == p[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == pLen) {
            return i - j;
        } else {
            return -1;
        }

    }

    /**
     * 根据模式字符串计算部分匹配表
     * 返回的next数组的元素是除当前字符外的前后缀公共元素长度的最大值，首元素为-1
     * 前缀是除最后一个字符外的所有含头部字符的组合，后缀是除第一个字符外的所有含尾部字符的组合
     *
     * @param p
     * @return
     */
    public int[] getNext(char[] p) {

        int pLen = p.length;

        //优化后的部分匹配表
        int[] next = new int[pLen];

        next[0] = -1;

        int k = -1;
        int j = 0;
        while (j < pLen - 1) {

            if (k == -1 || p[j] == p[k]) {

                ++k;
                ++j;

                ///next数组需要优化，当p[j]=p[next[j]]时，可能出现s[i]！=p[next[j]]再次失配的情况
                //next[j] = k;

                if (p[j] != p[k]) {
                    next[j] = k;
                } else {
                    //因为不能出现p[j] = p[ next[j ]]，所以当出现时需要继续递归，k = next[k] = next[next[k]]
                    next[j] = next[k];
                }

            } else {
                k = next[k];
            }
        }

        return next;
    }

}
