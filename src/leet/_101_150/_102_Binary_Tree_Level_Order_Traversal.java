package leet._101_150;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class _102_Binary_Tree_Level_Order_Traversal {
    /**
     * T = n
     * 宽度优先遍历，一层一层来做。即：
     * <p>
     * 将根节点插入队列中；
     * 创建一个新队列，用来按顺序保存下一层的所有子节点；
     * 对于当前队列中的所有节点，按顺序依次将儿子加入新队列，并将当前节点的值记录在答案中；
     * 重复步骤2-3，直到队列为空为止。
     * 时间复杂度分析：树中每个节点仅会进队出队一次，所以时间复杂度是 O(n)O(n)。
     */
    class Sol_bfs {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            /**
             * !!!
             */
            if (root != null) {
                q.add(root);
            }

            while (!q.isEmpty()) {
                List<Integer> level = new ArrayList<>();

                int size = q.size();
                // iterate all this level elements
                for (int i = 0; i < size; i++) {
                    TreeNode cur = q.remove();
                    /**
                     * !!! cur should not be null
                     */
                    level.add(cur.val);
                    if (cur.left != null) {
                        q.add(cur.left);
                    }

                    if (cur.right != null) {
                        q.add(cur.right);
                    }
                }

                ans.add(level);
            }

            return ans;
        }
    }

    class Sol_dfs {
        List<List<Integer>> ans;

        public List<List<Integer>> levelOrder(TreeNode root) {
            ans = new ArrayList<>();

            dfs(root, 0);
            return ans;
        }

        private void dfs(TreeNode root, int d) {
            // base case
            if (root == null) {
                return;
            }

            while (ans.size() <= d) {
                ans.add(new ArrayList<>());
            }

            ans.get(d).add(root.val);
            dfs(root.left, d + 1);
            dfs(root.right, d + 1);
        }
    }
}
