package leet._351_400;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
    // TODO : https://zxi.mytechroad.com/blog/graph/leetcode-399-evaluate-division/
    // https://www.acwing.com/solution/content/10234/

    /**
     * 1ms
     */
    public class Sol_BFS {
        Map<String, HashMap<String, Double>> g = new HashMap<>();

        public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
            for (int i = 0; i < equations.size(); ++i) {
                String x = equations.get(i).get(0);
                String y = equations.get(i).get(1);
                double k = values[i];
                g.computeIfAbsent(x, l -> new HashMap<String, Double>()).put(y, k);
                g.computeIfAbsent(y, l -> new HashMap<String, Double>()).put(x, 1.0 / k);
            }

            double[] ans = new double[queries.size()];

            for (int i = 0; i < queries.size(); ++i) {
                String x = queries.get(i).get(0);
                String y = queries.get(i).get(1);
                if (!g.containsKey(x) || !g.containsKey(y)) {
                    ans[i] = -1.0;
                } else {
                    ans[i] = divide(x, y, new HashSet<String>());
                }
            }

            return ans;
        }

        private double divide(String x, String y, Set<String> visited) {
            if (x.equals(y))
                return 1.0;
            visited.add(x);
            if (!g.containsKey(x))
                return -1.0;
            for (String n : g.get(x).keySet()) {
                if (visited.contains(n))
                    continue;
                visited.add(n);
                double d = divide(n, y, visited);
                if (d > 0)
                    return d * g.get(x).get(n);
            }
            return -1.0;
        }
    }

    public class Sol_UF {
        class Node {
            public String parent;
            public double ratio;

            public Node(String parent, double ratio) {
                this.parent = parent;
                this.ratio = ratio;
            }
        }

        /**
         * 3ms
         */
        class UnionFindSet {
            private Map<String, Node> parents = new HashMap<>();

            public Node find(String s) {
                if (!parents.containsKey(s))
                    return null;
                Node n = parents.get(s);
                if (!n.parent.equals(s)) {
                    Node p = find(n.parent);
                    n.parent = p.parent;
                    n.ratio *= p.ratio;
                }
                return n;
            }

            public void union(String s, String p, double ratio) {
                boolean hasS = parents.containsKey(s);
                boolean hasP = parents.containsKey(p);
                if (!hasS && !hasP) {
                    parents.put(s, new Node(p, ratio));
                    parents.put(p, new Node(p, 1.0));
                } else if (!hasP) {
                    parents.put(p, new Node(s, 1.0 / ratio));
                } else if (!hasS) {
                    parents.put(s, new Node(p, ratio));
                } else {
                    Node rS = find(s);
                    Node rP = find(p);
                    rS.parent = rP.parent;
                    rS.ratio = ratio / rS.ratio * rP.ratio;
                }
            }
        }

        public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
            UnionFindSet u = new UnionFindSet();

            for (int i = 0; i < equations.length; ++i)
                u.union(equations[i][0], equations[i][1], values[i]);

            double[] ans = new double[queries.length];

            for (int i = 0; i < queries.length; ++i) {
                Node rx = u.find(queries[i][0]);
                Node ry = u.find(queries[i][1]);
                if (rx == null || ry == null || !rx.parent.equals(ry.parent))
                    ans[i] = -1.0;
                else
                    ans[i] = rx.ratio / ry.ratio;
            }

            return ans;
        }
    }
}
