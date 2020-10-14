package leet._351_400;

import java.util.HashMap;
import java.util.Map;

public class _397_Integer_Replacement {
    Map<Long, Integer> dp = new HashMap<>();

    public int integerReplacement(int n) {
        return (int) f(n);
    }

    private int f(long n) {
        if (dp.containsKey(n)) {
            return dp.get(n);
        }
        if (n == 1)
            return 0;
        int res = 0;
        if (n % 2 == 0) {
            res = f(n / 2) + 1;
        } else {
            res = Math.min(f(n + 1), f(n - 1)) + 1;
        }
        dp.put(n, res);
        return res;
    }
}
