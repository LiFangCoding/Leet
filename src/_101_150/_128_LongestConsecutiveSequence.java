package _101_150;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * <p>
 * Your algorithm should run in O(n) complexity.
 * <p>
 * Example:
 * <p>
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class _128_LongestConsecutiveSequence {
    //TODO: difficult
    public static void main(String[] args) {
        _128_LongestConsecutiveSequence test = new _128_LongestConsecutiveSequence();
        System.out.println(test.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    public int longestConsecutive(int[] A) {
        int res = 0;
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();

        for (int x : A) {
            int left = leftMap.getOrDefault(x - 1, 0);
            int right = rightMap.getOrDefault(x + 1, 0);

            leftMap.put(x - left, Math.max(leftMap.get(x - left), left + 1 + right));
            rightMap.put(x + right, Math.max(rightMap.get(x + right), left + 1 + right));
            res = Math.max(res, left + 1 + right);

        }
        return res;
    }
}
