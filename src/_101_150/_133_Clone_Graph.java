package _101_150;

import graph.Node;

import java.util.*;

/**
 * Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 */
public class _133_Clone_Graph {
    public Node cloneGraph(Node node) {
        return bfsClone(node);
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
         */
        Node clonedSrc = new Node(src.val, new ArrayList<>());
        /**
         * map also to record visited
         */

        Queue<Node> q = new LinkedList<>();
        q.add(src);
        map.put(src, clonedSrc);

        while (!q.isEmpty()) {
            Node cur = q.remove();
            for (Node neigh : cur.neighbors) {
                if (!map.containsKey(neigh)) {
                    q.add(neigh);

                    Node clonedNeigh = new Node(neigh.val, new ArrayList<>());
                    map.put(neigh, clonedNeigh);
                }
                Node clonedCur = map.get(cur);
                clonedCur.neighbors.add(map.get(neigh));
            }
        }

        /**
         * !!! important return clonedsrc
         */
        return clonedSrc;
    }
}
