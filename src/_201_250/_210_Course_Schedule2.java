package _201_250;

import java.util.*;

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
        public int[] findOrder(int n, int[][] prerequisites) {
            int[] ans = new int[n];

            int[] indegree = new int[n];
            List<Integer>[] neighs = new List[n];

            for (int i = 0; i < n; i++) {
                neighs[i] = new ArrayList<>();
            }

            for (int[] req : prerequisites) {
                int start = req[1];
                int end = req[0];

                indegree[end]++;
                neighs[start].add(end);
            }

            Queue<Integer> q = new LinkedList<>();
            Set<Integer> marked = new HashSet<>();

            for (int i = 0; i < n; i++) {
                /**
                 * Here is the empty array if no sol exist
                 */
                if (indegree[i] == 0) {
                    q.add(i);
                    marked.add(i);
                }
            }

            int cnt = 0;
            while (!q.isEmpty()) {
                int curCourse = q.remove();
                ans[cnt++] = curCourse;

                /**
                 * Need to decrese the indegree.
                 * Should run small test cases
                 */
                for (int course : neighs[curCourse]) {
                    if (marked.contains(course)) {
                        return new int[0];
                    }

                    /**
                     * Important
                     */
                    indegree[course]--;
                    if (indegree[course] == 0) {
                        q.add(course);
                        marked.add(course);
                    }
                }
            }

            if (cnt == n) {
                return ans;
            }
            return new int[0];
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
