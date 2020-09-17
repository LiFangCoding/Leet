package leet._301_350;

import java.util.Arrays;

public class _322_Coin_Change {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount < 0) {
            return -1;
        }

        // f[i] means to get amount i, the fewest number need
        int[] f = new int[amount + 1];

        f[0] = 0;
        Arrays.sort(coins);

        for (int i = 1; i < f.length; i++) {
            // -1 means no way to get it
            f[i] = -1;
            for (int coin : coins) {
                if (i - coin >= 0 && f[i - coin] != -1) {
                    if (f[i] == -1) {
                        f[i] = f[i - coin] + 1;
                    } else {
                        f[i] = Math.min(f[i], f[i - coin] + 1);
                    }
                }
            }
        }

        return f[amount];
    }
}
