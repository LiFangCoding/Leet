package _1_50;

/**
 * Implement pow(x, n), which calculates x raised to the power n (xn).
 * <p>
 * Example 1:
 * <p>
 * Input: 2.00000, 10
 * Output: 1024.00000
 * Example 2:
 * <p>
 * Input: 2.10000, 3
 * Output: 9.26100
 * Example 3:
 * <p>
 * Input: 2.00000, -2
 * Output: 0.25000
 * Explanation: 2-2 = 1/22 = 1/4 = 0.25
 * Note:
 * <p>
 * -100.0 < x < 100.0
 * n is a 32-bit signed integer, within the range [−231, 231 − 1]
 */
public class _50_Pow_x_n {
    public static void main(String[] args) {
        _50_Pow_x_n test = new _50_Pow_x_n();
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE * -1);
        System.out.println(test.myPow(1, -2147483648));
    }

    /**
     * Be careful with the Integer.MIN_VALUE
     * -1 * Integer.MIN_VALUE = Integer.MIN_VALUE
     * -2147483648 * - 1 = -2147483648
     */
    public double myPow(double x, int n) {
        return myPowHelper(x, n);
    }

    public double myPowHelper(double x, long n) {
        if (n == 0) {
            return 1;
        }


        // careful of the Integer.MIN_VALUE here here.
        if (n < 0) {
            return myPowHelper(1 / x, -n);
        }

        double half = myPowHelper(x, n / 2);

        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public double myPow_Iterative(double x, int n) {
        if (n < 0) {
            return 1 / (x * myPow_Iterative(x, -(n + 1)));
        }

        double res = 1, tmp = x;

        while (n != 0) {
            if (n % 2 == 1) {
                res *= tmp;
            }
            tmp *= tmp;
            n /= 2;
        }

        return res;
    }
}
