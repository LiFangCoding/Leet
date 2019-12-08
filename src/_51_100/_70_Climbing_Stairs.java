package _51_100;

public class _70_Climbing_Stairs {
    public int climbStairs(int n) {
        /**
         * f(n) = f(n - 1) + f(n - 2)
         */
        int[] f = new int[n + 1];
        if (n <= 2) {
            return n;
        }

        /**
         * !!! be careful, if n == 1, no f[2] index.
         */
        f[1] = 1;
        f[2] = 2;

        for (int i = 3; i <= n; i++) {
            f[i] = f[i - 2] + f[i - 1];
        }

        return f[n];
    }
}
