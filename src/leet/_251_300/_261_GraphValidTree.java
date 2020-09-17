package leet._251_300;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given n nodes labeled from 0 to n-1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 5, and edges = [[0,1], [0,2], [0,3], [1,4]]
 * Output: true
 * Example 2:
 * <p>
 * Input: n = 5, and edges = [[0,1], [1,2], [2,3], [1,3], [1,4]]
 * Output: false
 * Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0,1] is the same as [1,0] and thus will not appear together in edges.
 */
public class _261_GraphValidTree {
    /**
     * 判断一个图是否为树结构就是判断这个图是否有环，如果无环且连同分量为1，则是树结构
     */
    public boolean validTree_BFS(int n, int[][] edges) {
        //构建邻接矩阵
        int[][] graph = new int[n][n];
        //有边的元素设置为1，没有边的元素设置为0
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }

        //进行BFS
        /**
         * 1 - 2 - 3
         *     -
         */
        Queue<Integer> q = new LinkedList<>();
        //从第一个节点开始搜索，这样就不会漏掉无边图的情况
        q.add(0);
        boolean[] visited = new boolean[n];

        while (!q.isEmpty()) {
            Integer cur = q.poll();
            visited[cur] = true;
            //获取邻接点
            for (int i = 0; i < n; i++) {
                //查看当前节点的邻接点
                if (graph[cur][i] == 1) {
                    //如果访问过，则返回false
                    if (visited[i]) {
                        return false;
                    }

                    //标记邻接点，入队列
                    visited[i] = true;
                    //涂黑访问过的节点
                    graph[cur][i] = 0;
                    graph[i][cur] = 0;
                    q.add(i);
                }
            }
        }

        //判断是否为单连通分量
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    //DFS
    public boolean validTree_DFS(int n, int[][] edges) {
        //构建邻接矩阵
        int[][] graph = new int[n][n];
        //有边的元素设置为1，没有边的元素设置为0
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = 1;
            graph[edge[1]][edge[0]] = 1;
        }

        //进行DFS
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        boolean[] visited = new boolean[n];

        while (!stack.isEmpty()) {
            Integer cur = stack.pop();
            visited[cur] = true;
            for (int i = 0; i < n; i++) {
                if (graph[cur][i] == 1) {
                    if (visited[i]) {
                        return false;
                    }

                    visited[i] = true;
                    graph[cur][i] = 0;
                    graph[i][cur] = 0;
                    stack.add(i);
                }
            }
        }

        //判断是否为单连通分量
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                return false;
        }
        return true;
    }
}
