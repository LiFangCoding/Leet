package _301_350;

import java.util.ArrayList;
import java.util.List;

/**
 * For an undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree. Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to find all the MHTs and return a list of their root labels.
 * <p>
 * Format
 * The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).
 * <p>
 * You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 * <p>
 * Example 1 :
 * <p>
 * Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]
 * <p>
 * 0
 * |
 * 1
 * / \
 * 2   3
 * <p>
 * Output: [1]
 * Example 2 :
 * <p>
 * Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
 * <p>
 * 0  1  2
 * \ | /
 * 3
 * |
 * 4
 * |
 * 5
 * <p>
 * Output: [3, 4]
 * Note:
 * <p>
 * According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”
 * The height of a rooted tree is the number of edges on the longest downward path between the root and a leaf.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-height-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _310_Minimum_height_trees {
  /**
   * 12ms
   * T = n
   * 从叶子结点开始，每一轮删除所有叶子结点。
   * 删除后，会出现新的叶子结点，此时再删除。
   * 重复以上过程直到剩余 1 个或 2 个结点，此时这 1 个或 2 个结点就是答案。
   * https://www.jiuzhang.com/problem/minimum-height-trees/
   * https://www.acwing.com/solution/content/344/
   */
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    List<Integer> ans = new ArrayList<>();

    if (n == 1) {
      ans.add(0);
      return ans;
    }

    List<Integer>[] tree = new ArrayList[n];
    for (int i = 0; i < n; i++) {
      tree[i] = new ArrayList<>();
    }
    int[] deg = new int[n];

    for (int[] e : edges) {
      tree[e[0]].add(e[1]);
      tree[e[1]].add(e[0]);
      deg[e[0]]++;
      deg[e[1]]++;
    }

    for (int i = 0; i < n; i++) {
      if (deg[i] == 1) {
        ans.add(i);
      }
    }

    while (n > 2) {
      List<Integer> next_ans = new ArrayList<>();
      for (int u : ans) {
        n--;
        for (int v : tree[u]) {
          deg[v]--;
          if (deg[v] == 1) {
            next_ans.add(v);
          }
        }
      }

      ans = next_ans;
    }

    return ans;
  }
}
