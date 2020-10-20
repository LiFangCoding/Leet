package leet._401_450;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _403_Frog_Jump {
    class Solution {
        // dp state. jump to which stone, the jump distance k
        // n stones, most jump n -1 times, jump distance at most n - 1
        // f(i, j). if there is valid way to jump from ith stone with j distance
        // last step jump distance k, k = j - 1, j, j + 1
        // sp = si - k. f(p, k)
        // 记忆化搜索. 优化常数

        int[][] f = new int[1200][1200];
        Map<Integer, Integer> map = new HashMap<>();
        int[] stones;

        int dp(int i, int j) {
            if (f[i][j] != -1) return f[i][j];
            f[i][j] = 0;
            for (int k = Math.max(1, j - 1); k <= j + 1; k++) {
                if (map.containsKey(stones[i] - k)) {
                    int p = map.get(stones[i] - k);
                    if (dp(p, k) > 0) {
                        f[i][j] = 1;
                        break;
                    }
                }
            }
            return f[i][j];
        }

        public boolean canCross(int[] _stones) {
            stones = _stones;
            int n = stones.length;
            for (int i = 0; i < n; i++) map.put(stones[i], i);
            for (int i = 0; i < f.length; i++) {
                Arrays.fill(f[i], -1);
            }

            f[0][1] = 1;
            for (int i = 0; i < n; i++) {
                if (dp(n - 1, i) > 0)
                    return true;
            }
            return false;
        }
    }

}
