package _351_400;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.
 * <p>
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 * <p>
 * The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.
 * <p>
 * According to the example above:
 * <p>
 * equations = [ ["a", "b"], ["b", "c"] ],
 * values = [2.0, 3.0],
 * queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 *  
 * <p>
 * The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-division
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _399_Evaluate_Division {
  //TODO: https://www.acwing.com/solution/content/10234/
  class Edge {
    String y;
    boolean isMul;
    double rank;

    public Edge(String y, double rank, boolean isMul) {
      this.y = y;
      this.rank = rank;
      this.isMul = isMul;
    }
  }

  Map<String, Set<Edge>> build(List<List<String>> equations, double[] values) {
    int n = equations.size();
    Map<String, Set<Edge>> graph = new HashMap<>();
    for (int i = 0; i < n; i++) {
      List<String> equation = equations.get(i);
      String x = equation.get(0);
      String y = equation.get(1);
      double rank = values[i];

      if (graph.get(x) == null)
        graph.put(x, new HashSet<>());
      graph.get(x).add(new Edge(y, rank, true));

      if (graph.get(y) == null)
        graph.put(y, new HashSet<>());
      graph.get(y).add(new Edge(x, rank, false));
    }
    return graph;
  }

  /**
   * BFS:
   * 1ms
   * T = ?
   * S = ?
   * <p>
   * DFS
   */
  class Sol_BFS {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
      Map<String, Set<Edge>> graph = build(equations, values);
      int n = queries.size();
      double[] result = new double[n];
      for (int i = 0; i < n; i++) {
        result[i] = suggest(queries.get(i), graph);
      }
      return result;
    }

    double suggest(List<String> query, Map<String, Set<Edge>> graph) {
      String x = query.get(0);
      String y = query.get(1);
      if (graph.get(x) == null || graph.get(y) == null)
        return -1.0;
      if (x.equals(y))
        return 1.0;
      return bfs(x, y, graph);

      // double[] res = {1.0, 1.0};
      // boolean r = dfs(x, y, res, graph);
      // graph.get(x).add(new Edge(y, res[0], true));
      // graph.get(y).add(new Edge(x, res[0], false));
      // return r ? res[0]/res[1] : -1.0;
    }

    double bfs(String x, String y, Map<String, Set<Edge>> graph) {
      Queue<String> queue = new LinkedList<>();
      Map<String, Double> values = new HashMap<>();
      queue.offer(x);
      values.put(x, 1.0);

      while (!queue.isEmpty()) {
        String top = queue.poll();
        double value = values.get(top);
        Set<Edge> edges = graph.get(top);
        for (Edge e : edges) {
          if (values.get(e.y) != null)
            continue;
          values.put(e.y, e.isMul ? value * e.rank : value / e.rank);
          queue.offer(e.y);
        }
      }
      Double res = values.get(y);
      return res == null ? -1.0 : res;
    }
  }
}
