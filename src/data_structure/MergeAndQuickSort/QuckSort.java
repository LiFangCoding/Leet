package data_structure.MergeAndQuickSort;

public class QuckSort {
    public static void sort(int[] a) {
        shuffle(a);
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }

        int idx = partition(a, l, r);
        sort(a, l, idx - 1);
        sort(a, idx + 1, r);
    }

    static int getK(int[] a, int k) {
        int i = 0, j = a.length - 1;
        while (i < j) {
            int idx = partition(a, i, j);
            if (idx > k) {
                j = idx - 1;
            } else if (idx < k) {
                i = idx + 1;
            } else {
                return a[idx];
            }
        }
        return a[i];
    }

    private static int partition(int[] a, int l, int r) {
        // partition into a[lo.. i -1], a[i], a[i +1..hi]
        int i = l, j = r + 1;
        int v = a[i];

        while (true) {
            // have ++
            while (i < r && a[++i] < v) ;
            while (j > l && a[--j] > v) ;

            if (i >= j) break;
            swap(a, i, j);
        }

        swap(a, l, j);
        return j;
    }


    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    /**
     * Rearranges an array of objects in uniformly random order
     * (under the assumption that {@code Math.random()} generates independent
     * and uniformly distributed numbers between 0 and 1).
     *
     * @param a the array to be shuffled
     */
    public static void shuffle(int[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            // choose index uniformly in [0, i]
            int r = (int) (Math.random() * (i + 1));
            swap(a, i, r);
        }
    }
}
