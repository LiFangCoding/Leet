import java.util.*;

/**
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 * <p>
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 * <p>
 *  
 * <p>
 * Follow up:
 * <p>
 * Recursive solution is trivial, could you do it iteratively?
 */
public class _590_n_ary_tree_postorder_traversa {
    List<Integer> res;

    public List<Integer> postorder(Node root) {
        res = new ArrayList<>();
        dfs(root);
        return res;
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }

        for (Node child : root.children) {
            dfs(child);
        }

        res.add(root.val);
    }

    public List<Integer> postorder_iterative(Node root) {
        Deque<Integer> deque = new LinkedList<>();
        if (root == null) {
            return new ArrayList<>();
        }

        Stack<Node> s = new Stack<>();
        s.add(root);

        while (!s.isEmpty()) {
            Node cur = s.pop();
            deque.addFirst(cur.val);

            for (Node child : cur.children) {
                s.push(child);
            }
        }

        return new ArrayList<>(deque);
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
