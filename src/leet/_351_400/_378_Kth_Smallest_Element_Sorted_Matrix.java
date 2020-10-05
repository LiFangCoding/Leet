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
    class Sol_ac {
        //二分  t是不是第k小.
        // 如果t是第k小， <= t的个数 >= k. 答案是t或者小于t
        // <= t的个数  < k, 答案在t的右边
        // logv = 32.
        // 统计 <= t的个数。 行递增，列递增。O(n)
        // T = nlogv
        // 时间复杂度为O(NlogL)O(NlogL)，LL代表数组最大值和最小值的差。矩阵保证了从左到右递增和从上到下递增，所以j只会从尾到头扫描一遍，所以时间复杂度是O(NlogL)
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;
            int l = matrix[0][0], r = matrix[n - 1][n - 1];
            // int l = Integer.MIN_VALUE;
            // int r = Integer.MAX_VALUE;

            while (l < r) {
                int mid = (int) ((0L + l + r) >> 1);
                // System.out.println(String.format("l : %d, r : %d, mid : %d", l, r, mid));
                // 从后往前扫描
                int i = matrix[0].length - 1;
                int cnt = 0;
                for (int j = 0; j < matrix.length; j++) {
                    while (i >= 0 && matrix[j][i] > mid) i--;
                    cnt += i + 1;
                }

                if (cnt >= k) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return r;
        }
    }

    public static void main(String[] args) {
        System.out.println((-1 + 0) / 2);
        System.out.println((-1 + 0) >> 1);

        System.out.println((1 + 0) / 2);
        System.out.println((1 + 0) >> 1);

        System.out.println((-2 + 1) / 2);
        System.out.println((-2 + 1) >> 1);
    }

    class Sol_old {
        class Solution {
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

                if (countNotMoreThanMid(matrix, l, n) >= k) {
                    return l;
                }
                return r;
            }

            private int countNotMoreThanMid(int[][] matrix, int mid, int n) {
                int count = 0;
                int col = 0, row = n;
                while (col <= n && row >= 0) {
                    if (matrix[row][col] <= mid) {
                        count += row + 1;
                        col++;
                    } else {
                        row--;
                    }
                }
                return count;
            }
        }
    }
}
