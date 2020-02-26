import common.TreeNode;

/**
 * Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.
 * <p>
 * The length of path between two nodes is represented by the number of edges between them.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input:
 * <p>
 * 5
 * / \
 * 4   5
 * / \   \
 * 1   1   5
 * Output: 2
 * <p>
 *  
 * <p>
 * Example 2:
 * <p>
 * Input:
 * <p>
 * 1
 * / \
 * 4   5
 * / \   \
 * 4   4   5
 * Output: 2
 * <p>
 *  
 * <p>
 * Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
 */
public class _687_LongestUnivaluePath {
    // ans = maxCount - 1
    int maxCount;

    public static void main(String[] args) {
        _687_LongestUnivaluePath test = new _687_LongestUnivaluePath();
        TreeNode root = TreeNode.stringToTreeNode("[1,4,5,4,4,5]");
        System.out.println(test.longestUnivaluePath(root));
    }

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }

        maxCount = 0;
        getOnePathCount(root);
        return maxCount - 1;
    }

    // get one path count and update the maxcount
    private int getOnePathCount(TreeNode root) {
        if (root == null) {
            return 0;
        }
        /**
         * Need to run it through all the nodes to get the maxCount.
         * int l = (root.left != null && root.val == root.left.val) ? getOnePathCount(root.left) : 0;
         * int r = (root.right != null && root.val == root.right.val) ? getOnePathCount(root.right) : 0;
         *
         * The root.left.left will never be executed.
         */

        int l = getOnePathCount(root.left);
        if (root.left != null && root.val != root.left.val) {
            l = 0;
        }
        int r = getOnePathCount(root.right);
        if (root.right != null && root.val != root.right.val) {
            r = 0;
        }

        int curCount = l + r + 1;
        maxCount = Math.max(maxCount, curCount);
        return Math.max(l, r) + 1;
    }
}
