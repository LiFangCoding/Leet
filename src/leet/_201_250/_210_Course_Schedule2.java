package leet._201_250;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * here are a total of n courses you have to take, labeled from 0 to n-1.
 * <p>
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 * <p>
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 * <p>
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 * <p>
 * Example 1:
 * <p>
 * Input: 2, [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 *              course 0. So the correct course order is [0,1] .
 * Example 2:
 * <p>
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
 * courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 *              So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 * Note:
 * <p>
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 */
public class _210_Course_Schedule2 {
    class Solution_BFS {
        public int[] findOrder(int n, int[][] edges) {
            int[] res = new int[n];

            // build graph
            List<List<Integer>> g = new ArrayList<>();
            for (int i = 0; i < n; i++)
                g.add(new ArrayList<>());
            int[] d = new int[n];

            for (int[] e : edges) {
                int b = e[0], a = e[1];
                g.get(a).add(b);
                d[b]++;
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (d[i] == 0)
                    q.add(i);
            }

            int idx = 0;
            while (!q.isEmpty()) {
                int t = q.remove();
                res[idx++] = t;

                for (int i : g.get(t)) {
                    if (--d[i] == 0) {
                        q.add(i);
                    }
                }
            }

            // here is idx. Since res len is always n
            if (idx < n)
                res = new int[0];
            return res;
        }
    }

    class Solution_DFS {
        boolean hasCycle;
        boolean[] onStack;
        boolean[] marked;
        Stack<Integer> reversePost;

        public int[] findOrder(int n, int[][] pres) {
            List<List<Integer>> adjs = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                adjs.add(new ArrayList<>());
            }

            for (int[] pre : pres) {
                int prevCourse = pre[1];
                int laterCourse = pre[0];

                adjs.get(prevCourse).add(laterCourse);
            }

            marked = new boolean[n];
            onStack = new boolean[n];
            reversePost = new Stack<>();
            hasCycle = false;

            for (int v = 0; v < n; v++) {
                if (!marked[v]) {
                    dfs(v, adjs);
                }
            }

            if (hasCycle) {
                return new int[0];
            }

            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                ans[i] = reversePost.pop();
            }

            return ans;
        }

        private void dfs(int v, List<List<Integer>> adjs) {
            marked[v] = true;
            onStack[v] = true;

            for (int w : adjs.get(v)) {
                if (hasCycle) {
                    return;
                } else if (!marked[w]) {
                    dfs(w, adjs);
                } else if (onStack[w]) {
                    hasCycle = true;
                    return;
                }
            }

            onStack[v] = false;
            reversePost.add(v);
        }
    }
}
