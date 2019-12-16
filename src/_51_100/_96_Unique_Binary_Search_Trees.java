package _51_100;

public class _96_Unique_Binary_Search_Trees {
    /**
     * Important:
     * find dp function
     * <p>
     * f[n] = sum (f[k] * f[n - k - 1]) k = 0 --- n-1
     */
    public int numTrees(int n) {
        int[] f = new int[n + 1];

        f[0] = 1;

        for (int i = 1; i <= n; i++) {
            f[i] = 0;

            for (int k = 0; k < i; k++) {
                f[i] += f[k] * f[i - k - 1];
            }
        }

        return f[n];
    }
}
