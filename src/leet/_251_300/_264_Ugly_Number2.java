package leet._251_300;

/**
 * Write a program to find the n-th ugly number.
 * <p>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 * <p>
 * Example:
 * <p>
 * Input: n = 10
 * Output: 12
 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note:  
 * <p>
 * 1 is typically treated as an ugly number.
 * n does not exceed 1690.
 */
public class _264_Ugly_Number2 {
    /**
     * 1 2 3 4 5 6 8 9 10 12
     *
     * 1 2 3 4 5 6
     */
    /**
     * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12是前10位的丑数，可以观察到后面的丑数都是前面的丑数与2/3/5的乘积，
     * 为了按照顺序排列，使用三个指针指代需要相乘的前丑数，比较这三个乘积的最小值作为新丑数，被选中的乘数指针+1
     * 使用dp[i]表示第i个丑数
     */
    public int nthUglyNumber(int n) {
        if (n == 0) {
            return 0;
        }
        int[] f = new int[n];
        f[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0;

        for (int i = 1; i < n; i++) {
            int val = Math.min(Math.min(f[i2] * 2, f[i3] * 3), f[i5] * 5);
            //插入指定位置
            f[i] = val;
            //调换指针位置
            if (f[i3] * 3 == val) {
                i3++;
            }
            if (f[i2] * 2 == val) {
                i2++;
            }
            if (f[i5] * 5 == val) {
                i5++;
            }
        }

        return f[n - 1];
    }
}
