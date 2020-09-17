package leet._251_300;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a non-empty binary search tree and a target value, find k values in the BST that are closest to the target.
 * <p>
 * Note:
 * <p>
 * Given target value is a floating point.
 * You may assume k is always valid, that is: k ≤ total nodes.
 * You are guaranteed to have only one unique set of k values in the BST that are closest to the target.
 * Example:
 * <p>
 * Input: root = [4,2,5,1,3], target = 3.714286, and k = 2
 * <p>
 * 4
 * / \
 * 2   5
 * / \
 * 1   3
 * <p>
 * Output: [4,3]
 * Follow up:
 * Assume that the BST is balanced, could you solve it in less than O(n) runtime (where n = total nodes)?
 */
public class _272_ClosestBinarySearchTreeValue2 {

    /**
     * 3ms
     * T= k + logn
     * S = logn
     * 使用令狐老师的基本思路重写，让代码更易读。 思路等同于从指定节点开始分别向前和向后遍历，直到找到k个最接近target的节点。
     * 使用prev和next两个栈分别记录前驱和后继，goPrev相当于反向中序遍历，goNext相当于正向中序遍历。
     * https://www.jiuzhang.com/solution/closest-binary-search-tree-value-ii/#tag-other-lang-java
     */
    class Sol_start_from_closest {
        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            Stack<TreeNode> next = new Stack<TreeNode>();
            Stack<TreeNode> prev = new Stack<TreeNode>();
            TreeNode node = root;

            // find the nodes closest to target
            while (node != null) {
                if (node.val < target) {
                    prev.push(node);
                    node = node.right;
                } else {
                    next.push(node);
                    node = node.left;
                }
            }

            List<Integer> ret = new LinkedList<Integer>();

            while (ret.size() < k) {
                double distp = prev.isEmpty() ? Double.MAX_VALUE : Math.abs(prev.peek().val - target);
                double distn = next.isEmpty() ? Double.MAX_VALUE : Math.abs(next.peek().val - target);

                // compare and find the closest node, and move the corresponding stack.
                if (distp < distn) {
                    ret.add(0, prev.peek().val);
                    goPrev(prev);
                } else {
                    ret.add(next.peek().val);
                    goNext(next);
                }
            }

            return ret;
        }

        private void goNext(Stack<TreeNode> st) {
            TreeNode r = st.pop().right;

            while (r != null) {
                st.push(r);
                r = r.left;
            }
        }

        private void goPrev(Stack<TreeNode> st) {
            TreeNode l = st.pop().left;

            while (l != null) {
                st.push(l);
                l = l.right;
            }
        }
    }

    /**
     * T = n
     * 1ms
     */
    class Sol_traversal {
        public List<Integer> closestKValues(TreeNode root, double target, int k) {
            List<Integer> ans = new LinkedList<Integer>();

            dfs(root, target, k, ans);
            return ans;
        }

        private void dfs(TreeNode root, double target, int k, List<Integer> ans) {
            if (root == null) {
                return;
            }

            dfs(root.left, target, k, ans);

            if (ans.size() < k) {
                ans.add(root.val);
            } else if (Math.abs(root.val - target) < Math.abs(ans.get(0) - target)) {
                ans.remove(0);
                ans.add(root.val);
            }

            dfs(root.right, target, k, ans);
        }
    }

    /**
     * TODO
     */
    List<Integer> inorderList;

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        inorderList = new ArrayList<>();

        int l = 0;
        int r = inorderList.size() - k;

        return null;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        helper(root.left);
        inorderList.add(root.val);
        helper(root.right);
    }
}
