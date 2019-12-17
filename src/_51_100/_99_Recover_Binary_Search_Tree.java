package _51_100;

import common.TreeNode;

public class _99_Recover_Binary_Search_Tree {
    private TreeNode firstElement = null;
    private TreeNode secondElement = null;
    private TreeNode lastElement = null;

    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);
        /**
         * !! Important:
         * because swap, so firstEle is the large one. Second ele is the small one
         */
        if (firstElement == null && lastElement != null && root.val < lastElement.val) {
            firstElement = lastElement;
        }
        /**
         * !! how to give value for firstElement and secondElement is important
         * firstEle is the small one
         *
         * Also, cannot use else if.
         * Because it can be the near one
         * cannot use else if here
         */
        if (firstElement != null && lastElement != null && root.val < lastElement.val) {
            secondElement = root;
        }

        lastElement = root;
        traverse(root.right);
    }
}
