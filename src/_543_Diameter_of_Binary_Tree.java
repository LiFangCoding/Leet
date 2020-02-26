import common.TreeNode;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 * <p>
 * Example:
 * Given a binary tree
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 * <p>
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class _543_Diameter_of_Binary_Tree {
    // ans is count - 1
    int maxCount;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        maxCount = 0;
        getOnePathLen(root);
        return maxCount - 1;
    }

    // get and update one path len
    private int getOnePathLen(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int l = getOnePathLen(root.left);
        int r = getOnePathLen(root.right);
        // !! update maxCount
        int count = l + r + 1;
        maxCount = Math.max(maxCount, count);
        return Math.max(l, r) + 1;
    }
}
