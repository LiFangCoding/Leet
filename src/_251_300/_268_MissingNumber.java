package _251_300;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */
public class _268_MissingNumber {
    public int missingNumber(int[] A) {
        int res = 0;

        int n = A.length;
        for (int i = 0; i <= n; i++) {
            res ^= i;
        }

        for (int num : A) {
            res ^= num;
        }

        return res;
    }
}
