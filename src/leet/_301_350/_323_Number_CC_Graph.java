package leet._301_350;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
 * <p>
 * 0          3
 * |          |
 * 1 --- 2    4
 * <p>
 * Output: 2
 * Example 2:
 * <p>
 * Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]
 * <p>
 * 0           4
 * |           |
 * 1 --- 2 --- 3
 * <p>
 * Output:  1
 * Note:
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-connected-components-in-an-undirected-graph
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _323_Number_CC_Graph {
    /**
     * 1ms
     * nlogn
     */
    class Sol_UF {
        public int countComponents(int n, int[][] edges) {
            UF uf = new UF(n);
            for (int[] e : edges) {
                uf.union(e[0], e[1]);
            }

            return uf.cnt();
        }

        class UF {
            int[] parent;
            int cnt;

            public UF(int n) {
                cnt = n;
                parent = new int[n];

                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                }
            }

            public int find(int p) {
                if (parent[p] == p) {
                    return p;
                }

                parent[p] = find(parent[p]);
                return parent[p];
            }

            public int cnt() {
                return cnt;
            }

            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);

                if (rootP == rootQ) {
                    return;
                }

                parent[rootP] = rootQ;
                cnt--;
            }
        }
    }

    /**
     * 5ms
     * Build graph and search.
     * V + E
     * https://www.acwing.com/solution/content/10142/
     */
    class Sol_dfs {
        public int countComponents(int n, int[][] edges) {
            return search(n, edges);
        }

        public int search(int n, int[][] edges) {
            boolean[] visit = new boolean[n];
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++)
                graph.add(new ArrayList<Integer>());
            for (int i = 0; i < edges.length; i++) {
                int x = edges[i][0];
                int y = edges[i][1];
                graph.get(x).add(y);
                graph.get(y).add(x);
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                if (!visit[i]) {
                    count++;
                    dfs(i, visit, graph);
                }
            }

            return count;
        }

        private void dfs(int x, boolean[] visit, List<List<Integer>> graph) {
            if (visit[x]) {
                return;
            }

            visit[x] = true;
            List<Integer> edge = graph.get(x);
            for (int i = 0; i < edge.size(); i++) {
                int y = edge.get(i);
                dfs(y, visit, graph);
            }
        }
    }
}
