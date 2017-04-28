package yao;

import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by root on 4/28/17.
 */
public class InsertionSort {

//    private SelectionSort() {
//    }

    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

//    public static void sort(Object[] a, Comparator comparator) {
//        int n = a.length;
//        for (int i = 0; i < n; i++) {
//            int min = i;
//            for (int j = i + 1; j < n; j++) {
//                if (less(comparator, a[j], a[min])) min = j;
//            }
//            exch(a, i, min);
//        }
//    }

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // is v < w ?
    private static boolean less(Comparator comparator, Object v, Object w) {
        return comparator.compare(v, w) < 0;
    }


    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // is the array a[] sorted?
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i - 1])) return false;
        return true;
    }

    // is the array a[] sorted?
    private static boolean isSorted(Object[] a, Comparator comparator) {
        return isSorted(a, comparator, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Object[] a, Comparator comparator, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(comparator, a[i], a[i - 1])) return false;
        return true;
    }


    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = "";
        if (scanner.hasNextLine()) {
            s = scanner.nextLine();
        }

        String[] a = s.split(" ");
        SelectionSort.sort(a);
        show(a);
    }


}
