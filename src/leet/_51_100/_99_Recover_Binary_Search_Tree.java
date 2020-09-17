package leet._51_100;

import common.TreeNode;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * <p>
 * Recover the tree without changing its structure.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,null,null,2]
 * <p>
 *    1
 *   /
 *  3
 *   \
 *    2
 * <p>
 * Output: [3,1,null,null,2]
 * <p>
 *    3
 *   /
 *  1
 *   \
 *    2
 * Example 2:
 * <p>
 * Input: [3,1,4,null,null,2]
 * <p>
 * 3
 * / \
 * 1   4
 *    /
 *   2
 * <p>
 * Output: [2,1,4,null,null,3]
 * <p>
 * 2
 * / \
 * 1   4
 *    /
 *  3
 * Follow up:
 * <p>
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/recover-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _99_Recover_Binary_Search_Tree {
    //TODO
    /**
     * 这道题目如果用递归做，递归的层数最坏是 O(n)O(n) 级别的，所以系统栈的空间复杂度是 O(n)O(n)，与题目要求的 O(1)O(1) 额外空间不符。
     * 同理用栈模拟递归的迭代方式的空间复杂度也是 O(n)O(n)，不符合题目要求。
     * <p>
     * 这道题目可以用Morris-traversal算法，该算法可以用额外 O(1)O(1) 的空间，以及 O(n)O(n) 的时间复杂度，中序遍历一棵二叉树。
     * <p>
     * Morris-traversal 算法流程：
     * 下图给了一个具体示例：
     * <p>
     * https://www.acwing.com/solution/content/181/
     */
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
        inorder(root.right);
    }
}
