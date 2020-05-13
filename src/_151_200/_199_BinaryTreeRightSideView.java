package _151_200;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 */
public class _199_BinaryTreeRightSideView {
    /**
     * 时间复杂度： O(N)O(N)，每个节点都入队出队了 1 次。
     * 空间复杂度： O(N)O(N)，使用了额外的队列空间。
     */
    class Sol_BFS {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> res = new ArrayList<>();

            Queue<TreeNode> q = new LinkedList<>();
            if (root != null) {
                q.add(root);
            }

            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode cur = q.remove();
                    if (i == size - 1) {
                        res.add(cur.val);
                    }

                    if (cur.left != null) {
                        q.add(cur.left);
                    }

                    if (cur.right != null) {
                        q.add(cur.right);
                    }
                }
            }

            return res;
        }
    }

    /**
     * 时间复杂度： O(N)O(N)，每个节点都访问了 1 次。
     * 空间复杂度： O(N)O(N)，因为这不是一棵平衡二叉树，二叉树的深度最少是 logNlogN, 最坏的情况下会退化成一条链表，深度就是 NN，因此递归时使用的栈空间是 O(N)O(N) 的。
     * <p>
     * 作者：sweetiee
     * 链接：https://leetcode-cn.com/problems/binary-tree-right-side-view/solution/jian-dan-bfsdfs-bi-xu-miao-dong-by-sweetiee/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Sol_dfs {
        List<Integer> ans;

        public List<Integer> rightSideView(TreeNode root) {
            ans = new ArrayList<>();
            dfs(root, 0);

            return ans;
        }

        private void dfs(TreeNode root, int d) {
            if (root == null) {
                return;
            }

            if (d >= ans.size()) {
                ans.add(root.val);
            }
            dfs(root.right, d + 1);
            dfs(root.left, d + 1);
        }
    }

}
