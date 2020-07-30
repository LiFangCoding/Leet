package data_structure.MergeAndQuickSort;

public class QuickSelect {
    /**
     * Partition array so that:
     * ・Entry a[j] is in place.
     * ・No larger entry to the left of j.
     * ・No smaller entry to the right of
     */
    public static Comparable select(Comparable[] a, int k) {
        shuffle(a);

        int lo = 0, hi = a.length - 1;
        while (hi > lo) {
            int j = partition(a, lo, hi);
            if (j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                return a[k];
            }
        }

        return a[k];
    }

    // lo < hi. cannot lo == hi, else ++i is bigger than array index
    private static int partition(Comparable[] a, int lo, int hi) {
        // partition into a[lo.. i -1], a[i], a[i +1..hi]
        int i = lo, j = hi + 1;

        Comparable v = a[lo];
        while (true) {
            while (less(a[++i], v)) {
                // compare with hi
                if (i == hi) {
                    break;
                }
            }

            while (less(v, a[--j])) {
                // compare with lo
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }

            exch(a, i, j);
        }

        exch(a, lo, j);
        return j;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    private static void shuffle(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            // [0, i]
            int r = (int) Math.random() * (i + 1);
            Comparable temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
}
