import java.util.PriorityQueue;

/**
 * You are given an m * n matrix, mat, and an integer k, which has its rows sorted in non-decreasing order.
 * <p>
 * You are allowed to choose exactly 1 element from each row to form an array. Return the Kth smallest array sum among all possible arrays.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: mat = [[1,3,11],[2,4,6]], k = 5
 * Output: 7
 * Explanation: Choosing one element from each row, the first k smallest sum are:
 * [1,2], [1,4], [3,2], [3,4], [1,6]. Where the 5th sum is 7.
 * Example 2:
 * <p>
 * Input: mat = [[1,3,11],[2,4,6]], k = 9
 * Output: 17
 * Example 3:
 * <p>
 * Input: mat = [[1,10,10],[1,4,5],[2,3,6]], k = 7
 * Output: 9
 * Explanation: Choosing one element from each row, the first k smallest sum are:
 * [1,1,2], [1,1,3], [1,4,2], [1,4,3], [1,1,6], [1,5,2], [1,5,3]. Where the 7th sum is 9.
 * Example 4:
 * <p>
 * Input: mat = [[1,1,10],[2,2,9]], k = 7
 * Output: 12
 *  
 * <p>
 * Constraints:
 * <p>
 * m == mat.length
 * n == mat.length[i]
 * 1 <= m, n <= 40
 * 1 <= k <= min(200, n ^ m)
 * 1 <= mat[i][j] <= 5000
 * mat[i] is a non decreasing array.
 */
public class _1439_FindKthSmallestSum {
    //     '''
// 逐行累加计算和，每一层都只用上一层最小的k个和参加下一轮加和
// 最后选第k小的和
// '''

    public int kthSmallest(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int val : mat[0]) {
            pq.add(val);
        }

        for (int i = 1; i < m; i++) {
            PriorityQueue<Integer> tmp = new PriorityQueue<>();
            for (int h = 0; h < k; h++) {
                if (pq.isEmpty()) {
                    break;
                }

                int val1 = pq.remove();
                for (int val2 : mat[i]) {
                    tmp.add(val1 + val2);
                }
            }

            pq = tmp;
        }

        for (int i = 0; i < k - 1; i++) {
            pq.remove();
        }

        return pq.remove();
    }
}
