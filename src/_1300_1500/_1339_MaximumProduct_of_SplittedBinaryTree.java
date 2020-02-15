package _1300_1500;

import common.TreeNode;

/**
 * Given a binary tree root. Split the binary tree into two subtrees by removing 1 edge such that the product of the sums of the subtrees are maximized.
 * <p>
 * Since the answer may be too large, return it modulo 10^9 + 7.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,2,3,4,5,6]
 * Output: 110
 * Explanation: Remove the red edge and get 2 binary trees with sum 11 and 10. Their product is 110 (11*10)
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,null,2,3,4,null,null,5,6]
 * Output: 90
 * Explanation:  Remove the red edge and get 2 binary trees with sum 15 and 6.Their product is 90 (15*6)
 * Example 3:
 * <p>
 * Input: root = [2,3,9,10,7,8,6,5,4,11,1]
 * Output: 1025
 * Example 4:
 * <p>
 * Input: root = [1,1]
 * Output: 1
 *  
 * <p>
 * Constraints:
 * <p>
 * Each tree has at most 50000 nodes and at least 2 nodes.
 * Each node's value is between [1, 10000].
 */
public class _1339_MaximumProduct_of_SplittedBinaryTree {
    long res;
    long sum;

    public static void main(String[] args) {
        _1339_MaximumProduct_of_SplittedBinaryTree test = new _1339_MaximumProduct_of_SplittedBinaryTree();

        TreeNode root = TreeNode.stringToTreeNode("[1,2,3,4,5,6]");

        System.out.println(test.maxProduct(root));
    }

    public int maxProduct(TreeNode root) {
        res = 0;
        if (root == null) {
            return 0;
        }

        sum = getSum(root);
        findMax(root);
        int kmod = (int) Math.pow(10, 9) + 7;

        return (int) (res % kmod);
    }

    private long findMax(TreeNode root) {
        if (root == null) {
            return 0;
        }

        long leftSum = findMax(root.left);
        long rightSum = findMax(root.right);


        res = Math.max(res,
                Math.max((sum - leftSum) * leftSum, (sum - rightSum) * rightSum));

        return root.val + leftSum + rightSum;
    }

    private long getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return root.val + getSum(root.left) + getSum(root.right);
    }
}
