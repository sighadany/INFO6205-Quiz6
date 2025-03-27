import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class QuickSort {

    // This class should not be instantiated.
    private QuickSort() { }

    /**
     * Rearranges the array in ascending order, using the natural order.
        @param a the array to be sorted
     */
//    public static void sort(Comparable[] a) {
//        Collections.shuffle(Arrays.asList(a));
//        sort(a, 0, a.length - 1);
//        assert isSorted(a);
//    }

    public static void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length);
        assert isSorted(a);
    }

    private static void sort(Comparable[] a, Comparable[] aux, int from, int to) {
        if (from >= to - 1) return;

        int mid = from + (to - from ) / 2;

        sort(a, aux, from, mid);

        sort(a, aux, mid, to);

        merge(a, aux, from, mid, to);
    }

    private static void merge(Comparable[] a, Comparable[] aux, int from, int mid, int to) {
        for(int k = from; k < to; k++) {
            aux[k] = a[k];
        }

        int i = from;
        int j = mid;

        for(int k = from; k < to; k++) {
            if(j >= to) {
                a[k] = aux[i++];
            } else if( i >= mid) {
                a[k] = aux[j++];
            } else if(less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }

    }

    // quicksort the subarray from a[lo] to a[hi]
//    private static void sort(Comparable[] a, int lo, int hi) {
//        if (hi <= lo) return;
//       //Student TODO
//    }

    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
    // and return the index j.
//    private static int partition(Comparable[] a, int lo, int hi) {
//        //Student TODO
//    }

    



   /***************************************************************************
    *  Helper sorting functions.
    ***************************************************************************/

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        if (v == w) return false;   // optimization when reference equals
        return v.compareTo(w) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }


   /***************************************************************************
    *  Check if array is sorted - useful for debugging.
    ***************************************************************************/
    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }


    // print array to standard output
    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }

    /**
     * Reads in a sequence of strings from standard input; quicksorts them;
     * and prints them to standard output in ascending order.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("Enter strings separated by spaces:");
        String[] a = scanner.nextLine().split("\\s+");
        scanner.close();
        QuickSort.sort(a);
        show(a);
        assert isSorted(a);
    }

}