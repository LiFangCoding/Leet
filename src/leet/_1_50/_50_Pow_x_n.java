package leet._1_50;

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
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE * -1);
        System.out.println(_50_Pow_x_n.Sol1.myPow(1, -2147483648));
    }

    static class Sol1 {
        public static double myPow(double x, int n) {
            // be careful -n can overflow
            if (x == 0) {
                return 0;
            }

            if (n == 0) {
                return 1;
            }

            // because can be int min value
            if (n < 0) {
                return (1 / x) * myPow(1 / x, -(n + 1));
            }

            double half = myPow(x, n / 2);
            if (n % 2 == 0) {
                return half * half;
            } else {
                return half * half * x;
            }
        }
    }

    class Sol2 {
        /**
         * Be careful with the Integer.MIN_VALUE
         * -1 * Integer.MIN_VALUE = Integer.MIN_VALUE
         * -2147483648 * - 1 = -2147483648
         */
        public double myPow(double x, int n) {
            return myPowHelper(x, n);
        }

        // here is long
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
    }

    class Sol3 {
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
}
