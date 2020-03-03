import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently occurred element) in the given BST.
 * <p>
 * Assume a BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *  
 * <p>
 * For example:
 * Given BST [1,null,2,2],
 * <p>
 * 1
 * \
 * 2
 * /
 * 2
 *  
 * <p>
 * return [2].
 * <p>
 * Note: If a tree has more than one mode, you can return them in any order.
 * <p>
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due to recursion does not count).
 */
public class _501_Find_Mode_in_Binary_Search_Tree {
    int maxCount;
    int curCount;
    TreeNode prev;
    List<Integer> anslist;

    public int[] findMode(TreeNode root) {
        maxCount = 0;
        curCount = 0;
        prev = null;
        anslist = new ArrayList<>();

        inorder(root);

        int size = anslist.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = anslist.get(i);
        }

        return ans;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        if (prev != null && prev.val == root.val) {
            curCount++;
        } else {
            curCount = 1;
        }

        if (curCount > maxCount) {
            maxCount = curCount;
            anslist.clear();
        }

        if (curCount == maxCount) {
            anslist.add(root.val);
        }

        prev = root;
        inorder(root.right);
    }
}
