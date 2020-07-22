package _101_150;//Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
//
// For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
//
//
//    1
//   / \
//  2   2
// / \ / \
//3  4 4  3
//
//
//
//
// But the following [1,2,2,null,3,null,3] is not:
//
//
//    1
//   / \
//  2   2
//   \   \
//   3    3
//
//
//
//
// Note:
//Bonus points if you could solve it both recursively and iteratively.
// Related Topics Tree Depth-first Search Breadth-first Search

//leetcode submit region begin(Prohibit modification and deletion)

import common.TreeNode;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class _101_Symmetric_Tree {
    class Sol_recursion {
        /**
         * T = n
         * 递归判断两个子树是否互为镜像。
         * <p>
         * 两个子树互为镜像当且仅当：
         * <p>
         * 两个子树的根节点值相等；
         * 第一棵子树的左子树和第二棵子树的右子树互为镜像，且第一棵子树的右子树和第二棵子树的左子树互为镜像；
         * 时间复杂度分析：从上到下每个节点仅被遍历一遍，所以时间复杂度是 O(n)。
         * https://www.acwing.com/solution/content/182/
         */
        public boolean isSymmetric(TreeNode root) {
            if (root == null) {
                return true;
            }
            return isMirror(root.left, root.right);
        }

        private boolean isMirror(TreeNode p, TreeNode q) {
            if (p == null || q == null) {
                return p == q;
            }

            return p.val == q.val && isMirror(p.left, q.right) && isMirror(p.right, q.left);
        }
    }

    class Sol_iterative {
        /**
         * T = n
         * 迭代 O(n)
         * 用栈模拟递归，对根节点的左子树，我们用中序遍历；对根节点的右子树，我们用反中序遍历。
         * 则两个子树互为镜像，当且仅当同时遍历两课子树时，对应节点的值相等。
         * <p>
         * 时间复杂度分析：树中每个节点仅被遍历一遍，所以时间复杂度是 O(n)
         *
         * @param root
         * @return
         */
        public boolean isSymmetric_iterative(TreeNode root) {
            if (root == null) {
                return true;
            }

            Stack<TreeNode> left = new Stack<>();
            Stack<TreeNode> right = new Stack<>();

            TreeNode lc = root.left;
            TreeNode rc = root.right;

            while (true) {
                while (lc != null && rc != null) {
                    left.push(lc);
                    right.push(rc);
                    lc = lc.left;
                    rc = rc.right;
                }

                // important to include.
                if (!(lc == null && rc == null)) {
                    return false;
                }

                if (left.isEmpty() || right.isEmpty()) {
                    break;
                }

                lc = left.pop();
                rc = right.pop();

                if (lc.val != rc.val) {
                    return false;
                }
                lc = lc.right;
                rc = rc.left;
            }

            return left.isEmpty() && right.isEmpty();
        }
    }
}
