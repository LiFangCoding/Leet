package leet._51_100;

import java.util.Arrays;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * <p>
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 * <p>
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class _66_Plus_One {
    public static void main(String[] args) {
        _66_Plus_One test = new _66_Plus_One();
        int[] A = { 8, 9, 9 };
        System.out.println(Arrays.toString(test.plusOne(A)));
    }

    /**
     * @param A digits array
     * @return
     */
    public int[] plusOne(int[] A) {
        if (A == null || A.length == 0) {
            return new int[] { 0 };
        }

        int len = A.length;
        int carry = 1;

        for (int i = len - 1; i >= 0 && carry != 0; i--) {
            int sum = A[i] + carry;
            A[i] = sum % 10;
            carry = sum / 10;
        }

        if (carry == 0) {
            return A;
        }

        int[] res = new int[len + 1];
        res[0] = 1;

        for (int j = 1; j < res.length; j++) {
            res[j] = A[j - 1];
        }

        return res;
    }
}
