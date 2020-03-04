package _51_100;

import common.TreeNode;

public class _99_Recover_Binary_Search_Tree {
    TreeNode prev;
    TreeNode first;
    TreeNode second;

    public void recoverTree(TreeNode root) {
        prev = null;
        first = null;
        second = null;

        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    /**
     * 中序遍历的结果就是二叉树搜索树所表示的有序数列。有序数列从小到大排序，但有两个数被交换了位置。共有两种情况：
     * <p>
     * 交换的是相邻两个数，例如 1 3 2 4 5 6，则第一个逆序对，就是被交换的两个数，这里是3和2；
     * 交换的是不相邻的数，例如 1 5 3 4 2 6，则第一个逆序对的第一个数，和第二个逆序对的第二个数，就是被交换的两个数，这里是5和2；
     * 找到被交换的数后，我们将它们换回来即可。
     * https://www.acwing.com/solution/LeetCode/content/181/
     */
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
                second = root;
            } else {
                second = root;
                return;
            }
        }
        prev = root;

        prev = root;
        inorder(root.right);
    }
}
