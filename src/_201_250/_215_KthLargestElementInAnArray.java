package _201_250;

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
    //TODO: understand 215
    public int findKthLargest(int[] A, int k) {
        int n = A.length;
        return solve(0, n - 1, A, k);
    }

    private int solve(int l, int r, int[] A, int k) {
        if (l == r) {
            return A[l];
        }

        int pivot = A[l];
        int i = l;
        int j = r;

        while (i < j) {
            while (i < j && A[j] < pivot) {
                j--;
            }

            if (i < j) {
                A[i++] = A[j];
            }

            while (i < j && A[i] >= pivot) {
                i++;
            }

            if (i < j) {
                A[j--] = A[i];
            }
        }

        if (i + 1 == k) {
            return pivot;
        } else if (i + 1 > k) {
            return solve(l, i - 1, A, k);
        } else {
            return solve(i + 1, r, A, k);
        }
    }
}
