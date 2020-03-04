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
    List<List<Integer>> ans;

    public List<List<Integer>> levelOrder(Node root) {
        ans = new ArrayList<>();
//        bfs(root);
        dfs(root, 0);
        return ans;
    }

    private void dfs(Node root, int d) {
        if (root == null) {
            return;
        }

        while (ans.size() <= d) {
            ans.add(new ArrayList<>());
        }

        ans.get(d).add(root.val);
        for (Node child : root.children) {
            dfs(child, d + 1);
        }
    }

    private void bfs(Node root) {
        Queue<Node> q = new LinkedList<>();
        if (root != null) {
            q.add(root);
        }

        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node cur = q.remove();
                level.add(cur.val);

                for (Node child : cur.children) {
                    //!!!
                    if (child != null) {
                        q.add(child);
                    }
                }
            }

            ans.add(level);
        }
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
