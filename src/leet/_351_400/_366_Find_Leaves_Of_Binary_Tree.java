package leet._351_400;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-leaves-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _366_Find_Leaves_Of_Binary_Tree {

    //T = n
    // depth is counted from leave node and  same depth move into the same idx of res
    // leave node depth is 0 and increased by up.
    // if one node's left and right tree depth is not same, use maxer depth
    //
    class Sol_dfs_Postorder {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> findLeaves(TreeNode root) {
            dfs(root);
            return res;
        }

        private int dfs(TreeNode root) {
            if (root == null) return -1;

            // left and add leaves into the list
            int left = dfs(root.left);

            // right
            int right = dfs(root.right);
            // root
            int cur = Math.max(left, right) + 1;
            if (cur >= res.size()) res.add(new ArrayList<>());
            res.get(cur).add(root.val);
            return cur;
        }
    }
    // T = n^2
    class Sol_DFS_Preorder_delete {
        List<Integer> path = new ArrayList<>();

        public List<List<Integer>> findLeaves(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            while (root != null) {
                path = new ArrayList<>();
                root = dfs(root);
                res.add(path);
            }

            return res;
        }

        //
        private TreeNode dfs(TreeNode root) {
            // deal with root first
            if (root == null) return null;
            if (isLeave(root)) {
                path.add(root.val);
                return null;
            }

            // left
            if (isLeave(root.left)) {
                path.add(root.left.val);
                root.left = null;
            } else {
                dfs(root.left);
            }

            //right
            if (isLeave(root.right)) {
                path.add(root.right.val);
                root.right = null;
            } else {
                dfs(root.right);
            }

            return root;
        }

        private boolean isLeave(TreeNode node) {
            return node != null && node.left == null && node.right == null;
        }
    }
}
