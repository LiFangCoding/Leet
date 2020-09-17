package leet._201_250;

import common.TreeNode;

/**
 * Given a binary tree, count the number of uni-value subtrees.
 * <p>
 * A Uni-value subtree means all nodes of the subtree have the same value.
 * <p>
 * Example :
 * <p>
 * Input:  root = [5,1,5,5,5,null,5]
 * <p>
 * 5
 * / \
 * 1   5
 * / \   \
 * 5   5   5
 * <p>
 * Output: 4
 */
public class _250_Count_Univalue_Subtrees {
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return getResType(root).count;
    }

    private ResType getResType(TreeNode root) {
        /**
         * !!! pay attention. here can be root.left != null but root.right == null
         * Then it will have error
         */
        if (root.left == null && root.right == null) {
            return new ResType(1, true);
        }

        int count = 0;
        boolean uni = true;

        if (root.left != null) {
            ResType left = getResType(root.left);
            count += left.count;
            uni = uni && (root.val == root.left.val) && left.uni;
        }

        if (root.right != null) {
            ResType right = getResType(root.right);
            count += right.count;
            uni = uni && (root.val == root.right.val) && right.uni;
        }

        if (uni) {
            count += 1;
        }

        return new ResType(count, uni);
    }

    public class ResType {
        int count;
        boolean uni;

        public ResType(int count, boolean uni) {
            this.count = count;
            this.uni = uni;
        }
    }
}
