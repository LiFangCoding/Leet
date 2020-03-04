package _151_200;

import common.TreeNode;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * <p>
 * Calling next() will return the next smallest number in the BST.
 * <p>
 *  
 * <p>
 * Example:
 * <p>
 * <p>
 * <p>
 * BSTIterator iterator = new BSTIterator(root);
 * iterator.next();    // return 3
 * iterator.next();    // return 7
 * iterator.hasNext(); // return true
 * iterator.next();    // return 9
 * iterator.hasNext(); // return true
 * iterator.next();    // return 15
 * iterator.hasNext(); // return true
 * iterator.next();    // return 20
 * iterator.hasNext(); // return false
 */
public class _173_BinaryTreeIterator {
    Stack<TreeNode> s;
    TreeNode cur;

    public _173_BinaryTreeIterator(TreeNode root) {
        s = new Stack<>();
        cur = root;
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        while (cur != null) {
            s.push(cur);
            cur = cur.left;
        }

        TreeNode node = s.pop();
        int ans = node.val;
        cur = node.right;

        return ans;
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return !s.isEmpty() || cur != null;
    }
}
