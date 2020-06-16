package _301_350;

import java.util.ArrayList;
import java.util.List;

/**
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example:
 * <p>
 * Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
 * Output: [1,1,2,3]
 * Explanation:
 * <p>
 * Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
 * <p>
 * 0 0 0
 * 0 0 0
 * 0 0 0
 * Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
 * <p>
 * 1 0 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
 * <p>
 * 1 1 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 * Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
 * <p>
 * 1 1 0
 * 0 0 1   Number of islands = 2
 * 0 0 0
 * Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
 * <p>
 * 1 1 0
 * 0 0 1   Number of islands = 3
 * 0 1 0
 * Follow up:
 * <p>
 * Can you do it in time complexity O(k log mn), where k is the length of the positions?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _305_Number_Islands2 {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    /**
     * 12ms
     * T = klog(m * n)
     * https://www.acwing.com/solution/content/633/
     * https://www.jiuzhang.com/solution/number-of-islands-ii/#tag-highlight-lang-java
     */
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> ans = new ArrayList<>();
        UF uf = new UF(m * n);

        for (int[] pos : positions) {
            int x = pos[0];
            int y = pos[1];

            int id = x * n + y;
            if (uf.isValid(id)) {
                ans.add(uf.getCnt());
                continue;
            }
            uf.setParent(id);

            for (int i = 0; i < 4; i++) {
                int newx = x + dx[i];
                int newy = y + dy[i];

                int newId = newx * n + newy;

                if (newx >= 0 && newx < m && newy >= 0 && newy < n && uf.isValid(newId)) {
                    uf.union(newId, id);
                }
            }

            ans.add(uf.getCnt());
        }

        return ans;
    }

    class UF {
        int[] parents;
        int cnt;

        UF(int N) {
            parents = new int[N];
            for (int i = 0; i < N; i++) {
                parents[i] = -1;
            }
            cnt = 0;
        }

        boolean isValid(int i) {
            return parents[i] >= 0;
        }

        void setParent(int i) {
            parents[i] = i;
            cnt++;
        }

        int find(int p) {
            if (p == parents[p]) {
                return p;
            }
            return parents[p] = find(parents[p]);
        }

        void union(int p, int q) {
            int root_p = find(p);
            int root_q = find(q);
            if (root_p != root_q) {
                parents[root_p] = root_q;
                cnt--;
            }
        }

        int getCnt() {
            return cnt;
        }
//        boolean query(int p, int q) {
//            int root_p = find(p);
//            int root_q = find(q);
//            return root_p == root_q;
//        }
    }
}
