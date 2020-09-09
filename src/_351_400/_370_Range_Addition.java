package _351_400;

/**
 * Assume you have an array of length n initialized with all 0's and are given k update operations.
 * <p>
 * Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
 * <p>
 * Return the modified array after all k operations were executed.
 * <p>
 * Example:
 * <p>
 * Input: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
 * Output: [-2,0,3,5,3]
 * Explanation:
 * <p>
 * Initial state:
 * [0,0,0,0,0]
 * <p>
 * After applying operation [1,3,2]:
 * [0,2,2,2,0]
 * <p>
 * After applying operation [2,4,3]:
 * [0,2,5,5,3]
 * <p>
 * After applying operation [0,2,-2]:
 * [-2,0,3,5,3]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-addition
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _370_Range_Addition {
    public int[] getModifiedArray(int n, int[][] updates) {
        int res[] = new int[n];
        for (int[] update : updates) {
            int a = Math.max(0, update[0]), b = Math.min(update[1], n - 1), x = update[2];

            for (int i = a; i <= b; i++) {
                res[i] += x;
            }
        }

        return res;
    }
}
