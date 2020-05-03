package _201_250;

import java.util.Random;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 * <p>
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class _215_KthLargestElementInAnArray {
    Random random = new Random();

    public int findKthLargest(int[] A, int k) {
        int len = A.length;
        k = len - k + 1;

        return getKth(A, k, 0, A.length - 1);
    }

    private int getKth(int[] A, int k, int l, int r) {
        if (l == r) {
            return A[l];
        }

        int idx = partition(A, l, r);

        if (idx > k - 1) {
            return getKth(A, k, l, idx - 1);
        } else if (idx == k - 1) {
            return A[idx];
        } else {
            return getKth(A, k, idx + 1, r);
        }
    }

    private int partition(int[] A, int l, int r) {
        // 在区间随机选择一个元素作为标定点
        if (r > l) {
            int randomIndex = l + 1 + random.nextInt(r - l);
            swap(A, l, randomIndex);
        }


        int pivot = A[l];
        // left to i is all <= pivatal
        int i = l + 1;
        // right to the j all >=
        int j = r;


        while (true) {
            // find item on lo to swap.  [2,1].  Index 2 out of bounds for length 2
            while (i <= j && A[i] < pivot) {
                i++;
            }

            // find item on hi to swap. [2,1]. Need to compare the i <= j and make decison.
            while (i <= j && A[j] > pivot) {
                j--;
            }

            // i > j or i >= j both works. Because before it will break when i <= j.
            if (i > j) {
                break;
            }

            swap(A, i++, j--);
        }

        // put partitioning item v at a[j]
        swap(A, l, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }


    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
