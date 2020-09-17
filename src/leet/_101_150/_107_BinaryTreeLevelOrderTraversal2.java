package leet._101_150;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 */
public class _107_BinaryTreeLevelOrderTraversal2 {
    class Sol_bfs {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> ans = new LinkedList<>();

            Queue<TreeNode> q = new LinkedList<>();

            if (root != null) {
                q.add(root);
            }

            while (!q.isEmpty()) {
                int size = q.size();

                List<Integer> level = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = q.remove();
                    level.add(cur.val);

                    if (cur.left != null) {
                        q.add(cur.left);
                    }

                    if (cur.right != null) {
                        q.add(cur.right);
                    }
                }

                ans.add(0, level);
            }

            //            Collections.reverse(ans);
            return ans;
        }
    }

    class Sol_dfs {
        List<List<Integer>> ans;

        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            ans = new ArrayList<>();
            dfs(root, 0);
            Collections.reverse(ans);
            return ans;
        }

        private void dfs(TreeNode root, int d) {
            if (root == null) {
                return;
            }

            while (ans.size() <= d) {
                ans.add(new ArrayList<>());
            }

            ans.get(d).add(root.val);
            // !!!Important d + 1
            dfs(root.left, d + 1);
            dfs(root.right, d + 1);
        }
    }
}
