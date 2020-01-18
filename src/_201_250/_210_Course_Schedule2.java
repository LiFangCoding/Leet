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
    public static void main(String[] args) {
        _210_Course_Schedule2 test = new _210_Course_Schedule2();
        int[][] A = {{1, 0}};
        System.out.println(Arrays.toString(test.findOrder(2, A)));

        A = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(test.findOrder(4, A)));
    }

    public int[] findOrder(int n, int[][] prerequisites) {
        int[] res = new int[n];

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
        Set<Integer> vt = new HashSet<>();

        for (int i = 0; i < n; i++) {
            /**
             * Here is the empty array if no sol exist
             */
            if (indegree[i] == 0) {
                q.add(i);
                vt.add(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.remove();
            res[count++] = cur;

            /**
             * Need to decrese the indegree.
             * Should run small test cases
             */
            for (int course : neighs[cur]) {
                if (vt.contains(course)) {
                    return new int[0];
                }

                /**
                 * Important
                 */
                indegree[course]--;
                if (indegree[course] == 0) {
                    q.add(course);
                    vt.add(course);
                }
            }
        }

        if (count == n) {
            return res;
        }
        return new int[0];
    }
}
