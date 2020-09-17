package leet._551_600;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 * <p>
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
 * <p>
 *  
 * <p>
 * Follow up:
 * <p>
 * Recursive solution is trivial, could you do it iteratively?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _589_N_ary_Tree_Preorder_Traversal {
    List<Integer> res;

    public List<Integer> preorder_recursion(Node root) {
        res = new ArrayList<>();

        dfs(root);
        return res;
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }

        res.add(root.val);
        for (Node child : root.children) {
            dfs(child);
        }
    }

    public List<Integer> preorder_iterative(Node root) {
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Stack<Node> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            Node cur = s.pop();
            res.add(cur.val);

            int size = cur.children.size();
            for (int i = size - 1; i >= 0; i--) {
                Node node = cur.children.get(i);
                if (node != null) {
                    s.push(node);
                }
            }
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
