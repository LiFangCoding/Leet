package _251_300;

/**
 * Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * Note:
 * <p>
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class _260_SingleNum3 {
    /**
     * 1.求数组的异或和为sum
     * 2.找出sum对应二进制数中为1的任意一位，假设该位为pos
     * 3.若pos=1,那么必然是该位置上有奇数个0和奇数个1，因为数组总数是偶数
     * 4.将pos=0的进行异或得到一个值，将pos=1的进行异或得到一个值;这是问题就转到leetcode 136,pos=0的在一个数组，pos=1的在一个数组
     */
    public int[] singleNumber(int[] A) {
        /**
         *  11 (3)
         * 101 (5)
         *
         *
         * 110  (One num at 2nd position is 1, another is 0
         *
         * 101 -> 010
         */
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum ^= A[i];
        }

        int pos = 0;

        for (int bit = 0; bit < 32; bit++) {
            if ((sum >> bit & 1) == 1) {
                pos = bit;
                break;
            }
        }

        int s1 = 0;
        int s2 = 0;

        for (int i = 0; i < A.length; i++) {
            if ((A[i] >> pos & 1) == 1) {
                s1 ^= A[i];
            } else {
                s2 ^= A[i];
            }
        }

        return new int[]{s1, s2};
    }
}
