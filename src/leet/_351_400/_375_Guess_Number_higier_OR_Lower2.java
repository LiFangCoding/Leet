package leet._351_400;

public class _375_Guess_Number_higier_OR_Lower2 {
    //最坏情况猜出来
    // dp用区间。 区间一般 f[i,j]，
    // 集合是所有可能的目标值在[i, j] 和 所有可能错误
    // 属性是最坏情况下最小值
    // f[i][j] 状态计算， x = i, i =1, k.. j.  每一种情况最坏情况下最小值的最小值
    // K直接猜到了，不是最坏情况
    // 决定于两侧。 不知道答案在哪边，所以取最坏值。 MAX(f[i][k - 1] , f[k + 1][j]) + k
    public int getMoneyAmount(int n) {
        int[][] f = new int[n + 2][n + 2];
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                f[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    f[i][j] = Math.min(f[i][j], Math.max(f[i][k - 1], f[k + 1][j]) + k);
                }
            }
        }
        return f[1][n];
    }
}
