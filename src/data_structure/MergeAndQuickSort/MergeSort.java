package data_structure.MergeAndQuickSort;

public class MergeSort {
    private static void sort(Comparable[] a, Comparable[] temp, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        int mid = lo + (hi - lo) / 2;
        sort(a, temp, lo, mid);
        sort(a, temp, mid + 1, hi);
        merge(a, temp, lo, mid, hi);
    }

    public static void sort(Comparable[] a) {
        Comparable[] temp = new Comparable[a.length];
        sort(a, temp, 0, a.length - 1);
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        // copy
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // merge
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}
