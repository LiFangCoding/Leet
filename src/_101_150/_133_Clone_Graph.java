package _101_150;

import graph.Node;

import java.util.*;

/**
 * Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 */
public class _133_Clone_Graph {
    Map<Node, Node> map;

    public Node cloneGraph(Node src) {
        if (src == null) {
            return null;
        }

        map = new HashMap<>();
        map.put(src, new Node(src.val, new ArrayList<>()));

        dfs(src);

        return map.get(src);
//      return bfsClone(src);
    }

    private Node bfsClone(Node src) {
        if (src == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        /**
         * because the neighbors also need to be cloned.
         * first, only add vertice. later connect with cloned one.
         * !!! res
         * map also to record visited
         */

        Queue<Node> q = new LinkedList<>();
        q.add(src);
        map.put(src, new Node(src.val, new ArrayList<>()));

        while (!q.isEmpty()) {
            Node cur = q.remove();
            for (Node neigh : cur.neighbors) {
                if (!map.containsKey(neigh)) {
                    q.add(neigh);

                    map.put(neigh, new Node(neigh.val, new ArrayList<>()));
                }
                map.get(cur).neighbors.add(map.get(neigh));
            }
        }

        /**
         * !!! important return clonedsrc
         */
        return map.get(src);
    }

    private void dfs(Node src) {
        for (Node neigh : src.neighbors) {
            if (!map.containsKey(neigh)) {
                map.put(neigh, new Node(neigh.val, new ArrayList<>()));
                map.get(src).neighbors.add(map.get(neigh));
                dfs(neigh);
            } else {
                map.get(src).neighbors.add(map.get(neigh));
            }
        }
    }
}
