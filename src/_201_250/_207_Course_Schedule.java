package _201_250;

import java.util.*;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * <p>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * <p>
 * Example 1:
 * <p>
 * Input: 2, [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0. So it is possible.
 * Example 2:
 * <p>
 * Input: 2, [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 *              To take course 1 you should have finished course 0, and to take course 0 you should
 *              also have finished course 1. So it is impossible.
 */
public class _207_Course_Schedule {
    //DFS
    class Sol_DFS {
      boolean[] marked;
      boolean[] onStack;
      boolean hasCycle;

      public boolean canFinish(int n, int[][] pres) {
        marked = new boolean[n];
        onStack = new boolean[n];
        hasCycle = false;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
          adj.add(new ArrayList<>());
        }

        for (int[] pre : pres) {
          adj.get(pre[1]).add(pre[0]);
        }

        for (int v = 0; v < n; v++) {
          if (!marked[v]) {
            dfs(v, adj);
          }
        }

        return !hasCycle;
      }

      private void dfs(int v, List<List<Integer>> adj) {
        onStack[v] = true;
        marked[v] = true;

        for (int w : adj.get(v)) {
          if (hasCycle) {
            return;
          } else if (!marked[w]) {
            dfs(w, adj);
          } else if (onStack[w]) {
            hasCycle = true;
          }
        }

        onStack[v] = false;
      }
    }

    //BFS
    public boolean canFinish(int n, int[][] prerequisites) {
        int[] indegree = new int[n];
        List<Integer>[] neighbors = new ArrayList[n];
        /**
         * !!! else it will be null reference
         */
        for (int i = 0; i < n; i++) {
            neighbors[i] = new ArrayList<>();
        }

        for (int[] edge : prerequisites) {
            int start = edge[1];
            int end = edge[0];

            neighbors[start].add(end);
            indegree[end]++;
        }

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> vt = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                vt.add(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.remove();
            count++;

            for (int neigh : neighbors[cur]) {
                if (vt.contains(neigh)) {
                    return false;
                }

                indegree[neigh]--;
                if (indegree[neigh] == 0) {
                    q.add(neigh);
                    vt.add(neigh);
                }
            }
        }

        return count == n;
    }
}
