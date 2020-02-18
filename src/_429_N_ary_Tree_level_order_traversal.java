import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 * <p>
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 */
public class _429_N_ary_Tree_level_order_traversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        if (root == null) {
            return res;
        }

        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node cur = q.remove();
                level.add(cur.val);

                for (Node child : cur.children) {
                    if (child != null) {
                        q.add(child);
                    }
                }
            }
            res.add(level);
        }

        return res;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
