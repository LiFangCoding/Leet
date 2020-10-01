package leet._301_350;

import java.util.*;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 * <p>
 * Note:
 * <p>
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * One must use all the tickets once and only once.
 * Example 1:
 * <p>
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * Example 2:
 * <p>
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 *              But it is larger in lexical order.
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reconstruct-itinerary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _332_Reconstruct_Itinerary {
    /**
     * 7ms
     * O(n)
     * 经典的有限图欧拉路径（一笔画）问题：找到一条路径，遍历所有边，点在路径中可以重复，边不可以重复。
     * <p>
     * 直接从起点开始dfs即可，每次选择一条没有遍历过的边，递归进行遍历。
     * 当把当前节点的所有出边都遍历完时，将该点加入路径序列。
     * 最终记录的路径是真正遍历路径的逆序，所以我们要将记录的路径逆序输出
     * <p>
     * T = n*logn
     * 每条边只遍历一次，但需要对每个点的所有出边按字典序排序，所以总时间复杂度是 O(nlogn)
     * https://www.acwing.com/solution/content/359/
     * https://leetcode-cn.com/problems/reconstruct-itinerary/solution/javadfsjie-fa-by-pwrliang/
     */
    List<String> revo = new ArrayList();
    Map<String, PriorityQueue<String>> g = new HashMap<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> e : tickets) {
            // a -> b
            String a = e.get(0);
            String b = e.get(1);
            if (!g.containsKey(a)) {
                g.put(a, new PriorityQueue<>());
            }
            g.get(a).add(b);
        }

        dfs("JFK");
        Collections.reverse(revo);
        return revo;
    }

    void dfs(String u) {
        // important not null
        while (g.get(u) != null && !g.get(u).isEmpty()) {
            String ver = g.get(u).remove();
            dfs(ver);
        }
        revo.add(u);
    }
}
