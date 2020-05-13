import common.TreeNode;

/**
 * Given an undirected tree, return its diameter: the number of edges in a longest path in that tree.
 * <p>
 * The tree is given as an array of edges where edges[i] = [u, v] is a bidirectional edge between nodes u and v.  Each node has labels in the set {0, 1, ..., edges.length}.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: edges = [[0,1],[0,2]]
 * Output: 2
 * Explanation:
 * A longest path of the tree is the path 1 - 0 - 2.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: edges = [[0,1],[1,2],[2,3],[1,4],[4,5]]
 * Output: 4
 * Explanation:
 * A longest path of the tree is the path 3 - 2 - 1 - 4 - 5.
 *  
 * <p>
 * Constraints:
 * <p>
 * 0 <= edges.length < 10^4
 * edges[i][0] != edges[i][1]
 * 0 <= edges[i][j] <= edges.length
 * The given edges form an undirected tree.
 */
public class _1245_Tree_Diameter {
    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        // [] -1 exp: 0
        if (root == null) {
            return 0;
        }

        ans = 0;

        onePathLen(root);

        return ans - 1;
        // ans need to be minus one
    }


    private int onePathLen(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int L = onePathLen(root.left);
        int R = onePathLen(root.right);

        ans = Math.max(ans, L + R + 1);
        return Math.max(L, R) + 1;
    }
}
