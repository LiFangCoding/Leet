package _1_50;

/**
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * <p>
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * The integer division should truncate toward zero.
 * <p>
 * Example 1:
 * <p>
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Example 2:
 * <p>
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Note:
 * <p>
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
 */
public class _29_DivideTwoIntegers {
    public static void main(String[] args) {
        _29_DivideTwoIntegers test = new _29_DivideTwoIntegers();
        int res = test.divide(-1, 1);
        System.out.println(res);

        System.out.println(test.divide(-2147483648, 1));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Math.abs(Integer.MIN_VALUE) will return MIN_VALUE
        long m = Math.abs((long) dividend);
        long n = Math.abs((long) divisor);
        int res = 0;

        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;

        while (m >= n) {
            long substractVal = n, times = 1;

            while (m >= (substractVal << 1)) {
                substractVal <<= 1;
                times <<= 1;
            }

            res += times;
            m -= substractVal;
        }

        return sign == 1 ? res : -res;
    }
}
