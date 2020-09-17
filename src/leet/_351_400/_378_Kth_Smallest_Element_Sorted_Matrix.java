package leet._351_400;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
 * <p>
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * <p>
 * Example:
 * <p>
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * return 13.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _378_Kth_Smallest_Element_Sorted_Matrix {
    /**
     * 0ms
     * T = n * log(max - min)
     * S = 1
     */
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length - 1;

        int l = matrix[0][0], r = matrix[n][n];

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            int count = countNotMoreThanMid(matrix, mid, n);
            if (count < k) {
                l = mid;
            } else {
                r = mid;
            }
        }

        /**
         * Special case:
         * [1,2]
         * [1,3]
         *
         * k = 1. Here we want the kth smallest element in sorted order,
         * not the kth distinct element.
         *
         * So the k = 1, it is 2. which cnt is 2 >= k = 1.
         */
        if (countNotMoreThanMid(matrix, l, n) >= k) {
            return l;
        }
        return r;
    }

    private int countNotMoreThanMid(int[][] matrix, int mid, int n) {
        int cnt = 0;
        int row = n, col = 0;

        while (col <= n && row >= 0) {
            if (matrix[row][col] <= mid) {
                cnt += row + 1;
                col++;
            } else {
                row--;
            }
        }

        return cnt;
    }
}
