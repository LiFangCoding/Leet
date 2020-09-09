package _351_400;

/**
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
 * Note: You can only put the bomb at an empty cell.
 * <p>
 * Example:
 * <p>
 * Input: [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
 * Output: 3
 * Explanation: For the given grid,
 * <p>
 * 0 E 0 0
 * E 0 W E
 * 0 E 0 0
 * <p>
 * Placing a bomb at (1,1) kills 3 enemies.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bomb-enemy
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _361_Bomb_Enemy {
    char wall = 'W', ene = 'E', empty = '0';
    char[][] g;

    public int maxKilledEnemies(char[][] grid) {
        g = grid;
        if (g == null || g.length == 0 || g[0].length == 0)
            return 0;
        int res = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[0].length; j++) {
                if (g[i][j] == empty) {
                    res = Math.max(res, get(i, j));
                }
            }
        }
        return res;
    }

    int get(int i, int j) {
        int res = 0;

        for (int k = j + 1; k < g[0].length && g[i][k] != wall; k++) {
            if (g[i][k] == ene)
                res++;
        }

        for (int k = j - 1; k >= 0 && g[i][k] != wall; k--) {
            if (g[i][k] == ene)
                res++;
        }

        for (int k = i + 1; k < g.length && g[k][j] != wall; k++) {
            if (g[k][j] == ene)
                res++;
        }

        for (int k = i - 1; k >= 0 && g[k][j] != wall; k--) {
            if (g[k][j] == ene)
                res++;
        }

        return res;
    }
}
