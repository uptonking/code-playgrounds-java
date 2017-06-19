package yao.step.search;

import java.util.Random;

/**
 * 哈希查找
 */
public class HashSearch {

    public static void main(String[] args) {

        int[] arr = new int[10];
        int[] hashTable = new int[arr.length*2+1];

        Random random = new Random();
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = random.nextInt(10)%10+10;
        }
        for(int a : arr){
            InsertHash(hashTable,a);
            System.out.print(a + " ");
        }

        System.out.println(SearchHash(arr[6],hashTable.length,hashTable));

    }

    private static boolean SearchHash(int a,int len,int[] ht) {
        int addr = Hash(a,len);
        while(ht[addr] != a){
            addr = (addr+1)%len;
            if(ht[addr] == 0 || addr == Hash(a,len)){
                return false;
            }
        }
        return true;
    }



    private static void InsertHash(int[] hashTable, int a) {
        int len = hashTable.length;
        int addr = Hash(a,len);
        while(hashTable[addr] != 0){
            addr = (addr+1)%len;
        }
        hashTable[addr] = a;
    }

    private static int Hash(int a,int len) {
        return a%len;
    }

}