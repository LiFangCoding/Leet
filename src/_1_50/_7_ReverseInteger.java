package _1_50;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class _7_ReverseInteger {
    /**
     * O(log10(x)). Because int型整数在十进制表示下最多有10位，对于每一位的计算量是常数级的.
     * Overflow  [-2^31, 2^31 - 1]
     */
    public int reverse(int x) {
        int r = 0;
        // 123 % 10 = 3, -123 % 10 = -3. for negative
        while (x != 0) {
            int d = x % 10;
            // 10r + d > max
            if (r > 0 && r > (Integer.MAX_VALUE - d) / 10)
                return 0;
            // 10r + d < min
            if (r < 0 && r < (Integer.MIN_VALUE - d) / 10)
                return 0;
            r = r * 10 + d;
            x /= 10;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(-12 % 10);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Math.abs(Integer.MIN_VALUE));
        System.out.println(Math.abs(-1));
    }
}
