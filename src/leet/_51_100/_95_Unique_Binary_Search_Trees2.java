package leet._51_100;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output:
 * [
 *   [1,null,3,2],
 *   [3,2,null,1],
 *   [3,1,null,null,2],
 *   [2,1,3],
 *   [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 *  
 * <p>
 * Constraints:
 * <p>
 * 0 <= n <= 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _95_Unique_Binary_Search_Trees2 {
    //TODO

    /**
     * O(Cn2n/(n+1))
     * 递归搜索所有方案。
     * <p>
     * 对于每段连续的序列 l,l+1,…rl,l+1,…r，枚举二叉搜索树根节点的位置；
     * 分别递归求出左右子树的所有方案；
     * 左子树的任意一种方案和右子树的任意一种方案拼在一起，可以得到当前节点的一种方案，所以我们将左右子树的所有方案两两组合，并记录在答案中。
     * 时间复杂度分析：我们来求一下当节点数是 nn 时，总共有多少种方案。假设方案数是 hnhn，则有 hn=∑n−1k=0hk∗hn−1−khn=∑k=0n−1hk∗hn−1−k。所以 hnhn 是卡特兰数，其通项公式是 hn=Cn2n/(n+1)hn=C2nn/(n+1)。所以时间复杂度是 O(Cn2n/(n+1))O(C2nn/(n+1))。
     * <p>
     * 作者：yxc
     * 链接：https://www.acwing.com/solution/content/177/
     * 来源：AcWing
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public List<TreeNode> generateTrees(int n) {
        /**
         * 1,2...n
         * Find the root.
         * Then 1 ->  root - 1, generate left search
         * root + 1 -> n, generate right
         */
        if (n == 0) {
            return new ArrayList<>();
        }

        return generateTrees(1, n);
    }

    // List<TreeNode> is the list of all the root nodes
    public List<TreeNode> generateTrees(int l, int r) {
        List<TreeNode> ans = new ArrayList<>();

        if (l > r) {
            ans.add(null);
            return ans;
        }

        if (l == r) {
            ans.add(new TreeNode(l));
            return ans;
        }

        for (int i = l; i <= r; i++) {
            List<TreeNode> left = generateTrees(l, i - 1);
            List<TreeNode> right = generateTrees(i + 1, r);

            for (TreeNode node1 : left) {
                for (TreeNode node2 : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = node1;
                    root.right = node2;
                    ans.add(root);
                }
            }
        }

        return ans;
    }
}
