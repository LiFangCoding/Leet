package leet._101_150;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class _136_Single_num {
    public static void main(String[] args) {
        _136_Single_num test = new _136_Single_num();
        int[] A = { 2, 2, 1 };
        System.out.println(test.singleNumber(A));

        A = new int[] { 4, 1, 2, 1, 2 };
        System.out.println(test.singleNumber(A));
    }

    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }
        int res = 0;

        for (int num : A) {
            res ^= num;
        }

        return res;
    }
}
