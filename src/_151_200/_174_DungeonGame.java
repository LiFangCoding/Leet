package _151_200;

import java.util.Arrays;

/**
 * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
 * <p>
 * The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
 * <p>
 * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
 * <p>
 * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
 * <p>
 *  
 * <p>
 * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
 * <p>
 * For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
 * <p>
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 *  
 * <p>
 * Note:
 * <p>
 * The knight's health has no upper bound.
 * Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 */
public class _174_DungeonGame {
  /**
   * 3ms
   * T = m * n
   * 此题不能直接从正向动态规划的原因是不确定起始点的值，但我们可以发现，到终点之后健康值为 1 一定是最优的。
   * 可以考虑从终点到起点进行动态规划。
   * 设状态 f(i,j)表示从 (i, j) 成功到达终点，(i, j) 处需要具备的最少健康值。 到(i, j)点需要最少的血量
   * 初始时，f(m−1,n−1)为 −max(dungeon[m−1][n−1],0)+1，其余为正无穷。
   * 转移时，f(i,j)=min(f(i+1,j),f(i,j+1))−dungeon[i][j]；如果 f(i,j)<=0，表示道路上的补给实在太多了，但此时健康值不能小 于0，所以此时需要修正 f(i,j)=1，即下限为 1。
   * 最终答案为 f(0,0)
   * <p>
   * 这题不能直接求路径和最大，因为，如果走某一个点和小于等于0，就挂了。
   * 可以倒着走，遇到公主后，血量最少为1.
   * https://www.acwing.com/solution/content/259/
   * https://www.acwing.com/solution/content/4499/
   */
    public int calculateMinimumHP(int[][] dungeon) {
      int INF = Integer.MAX_VALUE;
      int m = dungeon.length, n = dungeon[0].length;

      int[][] f = new int[m][n];
      for (int[] arr : f) {
        Arrays.fill(arr, INF);
      }

      f[m - 1][n - 1] = Math.max(-dungeon[m - 1][n - 1], 0) + 1;

      for (int i = m - 1; i >= 0; i--)
        for (int j = n - 1; j >= 0; j--) {
          if (i < m - 1)
            f[i][j] = Math.min(f[i][j], f[i + 1][j] - dungeon[i][j]);

          if (j < n - 1)
            f[i][j] = Math.min(f[i][j], f[i][j + 1] - dungeon[i][j]);

          f[i][j] = f[i][j] <= 0 ? 1 : f[i][j];
        }

      return f[0][0];
    }
}
