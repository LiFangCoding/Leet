package _101_150;

import common.TreeNode;

import java.util.*;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class _103_BinaryTree_Zigzag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        /**
         * !!!
         */
        if (root != null) {
            queue.add(root);
        }

        boolean inorder = true;
        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.remove();
                /**
                 * !!! cur should not be null
                 */
                level.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }

                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }

            if (!inorder) {
                Collections.reverse(level);
            }
            res.add(level);
            inorder = !inorder;
        }

        return res;
    }
}
