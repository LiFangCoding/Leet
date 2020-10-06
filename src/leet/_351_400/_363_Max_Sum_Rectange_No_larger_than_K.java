package leet._351_400;

import java.util.TreeSet;

public class _363_Max_Sum_Rectange_No_larger_than_K {
    //子矩阵是四个维度，四条边。枚举左右下。
    // 确定上边。用前缀和。si - sj <=k，是从 j + 1 to i. sj >= si - k. 要让sj最小。
    // 在i上方，找到大于等于一个数的最小值。 set里面有lowerbound.
    // 枚举左右边界m2， 枚举下边界 n, 找到sj确定上边是log n, 所以是m2nlogn
    // si可以用二维前缀和

    int[][] s;

    public int maxSumSubmatrix(int[][] w, int K) {
        int n = w.length, m = w[0].length;
        s = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                s[i][j] = s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1] + w[i - 1][j - 1];
            }
        }

        int res = Integer.MIN_VALUE;
        // 行数大于列数，所以枚举列数
        for (int i = 1; i <= m; i++) {
            for (int j = i; j <= m; j++) {
                TreeSet<Integer> S = new TreeSet<>();
                // 防止边界情况.　当si - K ==0 时，不用减去数，就是对的了
                S.add(0);
                //下边界
                for (int k = 1; k <= n; k++) {
                    int si = get(1, i, k, j);
                    // >= val 's min val
                    Integer it = S.ceiling(si - K);
                    if (it != null) {
                        res = Math.max(res, si - it);
                    }
                    S.add(si);
                }
            }
        }
        return res;
    }

    //快速求子矩阵的和
    int get(int x1, int y1, int x2, int y2) {
        return s[x2][y2] - s[x1 - 1][y2] - s[x2][y1 - 1] + s[x1 - 1][y1 - 1];
    }
}
