package _101_150;

import graph.Node;

import java.util.*;

/**
 * Given a reference of a node in a connected undirected graph, return a deep copy (clone) of the graph. Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 */
public class _133_Clone_Graph {
    class Sol_bfs {
      public Node cloneGraph(Node node) {
        if (node == null) {
          return node;
        }

        // Hash map to save the visited node and it's respective clone
        // as key and value respectively. This helps to avoid cycles.
        HashMap<Node, Node> visited = new HashMap();

        // Put the first node in the queue
        LinkedList<Node> queue = new LinkedList<Node> ();
        queue.add(node);
        // Clone the node and put it in the visited dictionary.
        visited.put(node, new Node(node.val, new ArrayList()));

        // Start BFS traversal
        while (!queue.isEmpty()) {
          // Pop a node say "n" from the from the front of the queue.
          Node n = queue.remove();
          // Iterate through all the neighbors of the node "n"
          for (Node neighbor: n.neighbors) {
            if (!visited.containsKey(neighbor)) {
              // Clone the neighbor and put in the visited, if not present already
              visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
              // Add the newly encountered node to the queue.
              queue.add(neighbor);
            }
            // Add the clone of the neighbor to the neighbors of the clone node "n".
            visited.get(n).neighbors.add(visited.get(neighbor));
          }
        }

        // Return the clone of the node from visited.
        return visited.get(node);
      }
    }

    class Sol_dfs {
      private HashMap <Node, Node> visited = new HashMap <> ();

      /**
       * node, copy it and connect to other copied nodes
       * If already visited, it means it is alreay as node of function.
       * It means it is copied and connected to other nodes.
       */
      public Node cloneGraph(Node node) {
        if (node == null) {
          return node;
        }

        // If the node was already visited before.
        // Return the clone from the visited dictionary.
        if (visited.containsKey(node)) {
          return visited.get(node);
        }

        // Create a clone for the given node.
        // Note that we don't have cloned neighbors as of now, hence [].
        Node cloneNode = new Node(node.val, new ArrayList());
        // The key is original node and value being the clone node.
        visited.put(node, cloneNode);

        // Iterate through the neighbors to generate their clones
        // and prepare a list of cloned neighbors to be added to the cloned node.
        for (Node neighbor: node.neighbors) {
          cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        return cloneNode;
      }
    }
}
