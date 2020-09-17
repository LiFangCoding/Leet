package leet._601_650;

import common.TreeNode;

/**
 * Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
 * <p>
 * You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * Output:
 * Merged tree:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 *  
 * <p>
 * Note: The merging process must start from the root nodes of both trees.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _617_MergeTwoBinaryTrees {
    //TODO: add other solutions
    // https://leetcode-cn.com/problems/merge-two-binary-trees/solution/dong-hua-yan-shi-di-gui-die-dai-617he-bing-er-cha-/

    /**
     * 1ms
     * T = N. N is the number of nodes
     * S = h
     */
    class Sol_null_exception {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) {
                return null;
            }

            // Null pointer exception. t1 is null, t1.left.
            TreeNode L = mergeTrees(t1 == null ? t1 : t1.left, t2 == null ? t2 : t2.left);
            TreeNode R = mergeTrees(t1 == null ? t1 : t1.right, t2 == null ? t2 : t2.right);

            int val = 0;
            if (t1 != null) {
                val += t1.val;
            }

            if (t2 != null) {
                val += t2.val;
            }

            TreeNode root = new TreeNode(val);
            root.left = L;
            root.right = R;
            return root;
        }
    }

}
