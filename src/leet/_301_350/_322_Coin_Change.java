package leet._301_350;

import java.util.Arrays;

public class _322_Coin_Change {
    class Sol_dp_max {
        //面额是体积vi, 价值1， m是背包容量amount
        public int coinChange(int[] coins, int m) {
            int[] f = new int[m + 1];
            // cannot add 1, overflow
            Arrays.fill(f, (int) 1e8);
            f[0] = 0;
            for (int v : coins) {
                for (int j = v; j <= m; j++) {
                    f[j] = Math.min(f[j], f[j - v] + 1);
                }
            }

            if (f[m] == (int) 1e8)
                return -1;
            return f[m];
        }
    }

    class Sol_dp_negative {
        public int coinChange(int[] coins, int m) {
            int[] f = new int[m + 1];
            // cannot add 1, overflow
            Arrays.fill(f, -1);
            f[0] = 0;
            for (int v : coins) {
                for (int j = v; j <= m; j++) {
                    if (f[j - v] != -1) {
                        if (f[j] == -1) {
                            f[j] = f[j - v] + 1;
                        } else {
                            f[j] = Math.min(f[j - v] + 1, f[j]);
                        }
                    }
                }
            }

            return f[m];
        }
    }
}
