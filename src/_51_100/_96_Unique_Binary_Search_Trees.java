package _51_100;

import java.util.HashMap;
import java.util.Map;

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

    class Soltion_dp {
        Map<String, Integer> map;

        public int numTrees(int n) {
            if (n == 0) {
                return 0;
            }

            map = new HashMap<>();
            return num(1, n);
        }

        // can has duplicate cal
        private int num(int l, int r) {
            String key = " " + l + "," + r;
            if (map.containsKey(key)) {
                return map.get(key);
            }
            if (l > r) {
                return 1;
            }

            int ans = 0;
            for (int i = l; i <= r; i++) {
                int lRes = num(l, i - 1);
                int rRes = num(i + 1, r);

                ans += lRes * rRes;
            }

            map.put(key, ans);
            return ans;
        }
    }
}
