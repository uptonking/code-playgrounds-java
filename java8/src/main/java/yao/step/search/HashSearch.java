package yao.step.search;

import java.util.Random;

/**
 * 哈希查找
 */
public class HashSearch {

    /**
     * @param a
     * @param key
     * @return 哈希地址
     */
    public static int searchHashtable(int[] a, int key) {

        int[] htable = buildHashtable(a);
        int hashLen = htable.length;

        int keyAddr = hashMod(key, hashLen);
        while (htable[keyAddr] != key && htable[keyAddr] != 0) {
            keyAddr = hashMod(keyAddr + 1, hashLen);
        }

        if (htable[keyAddr] == 0) {
            return -1;
        }

        return keyAddr;
    }

    /**
     * 哈希函数可修改，这里选择的是除数取余法
     *
     * @param a
     * @return 哈希表，由0和数组a元素构成的稀疏数组
     */
    public static int[] buildHashtable(int[] a) {

        if (a == null || a.length == 0) {
            return null;
        }

        //初始化存储哈希地址的数组，长度大于等于数组长度
        int length = a.length;
        int hashLen = length * 2 + 1;
        int[] hashtable = new int[hashLen];

        for (int i = 0; i < length; i++) {
            int addr = hashMod(a[i], hashLen);
            while (hashtable[addr] != 0) {
                addr = (addr + 1) % hashLen;
            }
            hashtable[addr] = a[i];
        }

        return hashtable;
    }

    public static int hashMod(int key, int len) {
        return key % len;
    }

//============================================哈希查找方法分割线========================================

    /**
     * 在Hash表中查找数组元素
     *
     * @param a
     * @param len
     * @param ht
     * @return
     */
    private static boolean SearchHash(int a, int len, int[] ht) {
        int addr = Hash(a, len);
        while (ht[addr] != a) {
            addr = (addr + 1) % len;
            if (ht[addr] == 0 || addr == Hash(a, len)) {
                return false;
            }
        }
        return true;
    }


    /**
     * 建立哈希表
     *
     * @param hashTable
     * @param a
     */
    private static void InsertHash(int[] hashTable, int a) {
        int len = hashTable.length;
        int addr = Hash(a, len);

        while (hashTable[addr] != 0) {
            addr = (addr + 1) % len;
        }

        hashTable[addr] = a;
    }

    /**
     * 哈希函数设置
     * 除数取余法
     *
     * @param a
     * @param len
     * @return
     */
    private static int Hash(int a, int len) {
        return a % len;
    }

    //    public static void main(String[] args) {
//
//        int[] arr = new int[10];
//        int[] hashTable = new int[arr.length * 2 + 1];
//
//        Random random = new Random();
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = random.nextInt(10) % 10 + 10;
//        }
//
//        for (int a : arr) {
//            InsertHash(hashTable, a);
//            System.out.print(a + " ");
//        }
//
//        System.out.println(SearchHash(arr[6], hashTable.length, hashTable));
//
//    }

}