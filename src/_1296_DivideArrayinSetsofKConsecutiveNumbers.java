import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into sets of k consecutive numbers
 * Return True if its possible otherwise return False.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,3,4,4,5,6], k = 4
 * Output: true
 * Explanation: Array can be divided into [1,2,3,4] and [3,4,5,6].
 * Example 2:
 * <p>
 * Input: nums = [3,2,1,2,3,4,3,4,5,9,10,11], k = 3
 * Output: true
 * Explanation: Array can be divided into [1,2,3] , [2,3,4] , [3,4,5] and [9,10,11].
 * Example 3:
 * <p>
 * Input: nums = [3,3,2,2,1,1], k = 3
 * Output: true
 * Example 4:
 * <p>
 * Input: nums = [1,2,3,4], k = 3
 * Output: false
 * Explanation: Each array should be divided in subarrays of size 3.
 *  
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 1 <= k <= nums.length
 */
public class _1296_DivideArrayinSetsofKConsecutiveNumbers {
    public boolean isPossibleDivide(int[] A, int k) {
        if (A == null || A.length == 0) {
            return false;
        }

        if (A.length % k != 0) {
            return false;
        }

        TreeMap<Integer, Integer> m = new TreeMap<>();

        for (int num : A) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        Queue<int[]> queue = new LinkedList<>();

        while (m.size() != 0) {
            int s = m.firstKey();
            for (int i = 0; i < k; i++) {
                if (!m.containsKey(s + i)) {
                    return false;
                }

                int val = m.get(s + i) - 1;
                if (val == 0) {
                    m.remove(s + i);
                } else {
                    m.put(s + i, val);
                }
            }
        }

        return true;
    }
}
