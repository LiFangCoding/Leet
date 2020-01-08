package _101_150;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class _102_Binary_Tree_Level_Order_Traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        /**
         * !!!
         */
        if (root != null) {
            q.add(root);
        }

        while (!q.isEmpty()) {
            int size = q.size();

            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.remove();
                /**
                 * !!! cur should not be null
                 */
                level.add(cur.val);
                if (cur.left != null) {
                    q.add(cur.left);
                }

                if (cur.right != null) {
                    q.add(cur.right);
                }
            }

            res.add(level);
        }

        return res;
    }
}
