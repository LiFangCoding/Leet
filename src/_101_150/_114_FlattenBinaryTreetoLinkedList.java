package _101_150;

import common.TreeNode;

import java.util.Stack;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 * <p>
 * For example, given the following tree:
 * <p>
 * 1
 * / \
 * 2   5
 * / \   \
 * 3   4   6
 * The flattened tree should look like:
 * <p>
 * 1
 * \
 * 2
 * \
 * 3
 * \
 * 4
 * \
 * 5
 * \
 * 6
 */
public class _114_FlattenBinaryTreetoLinkedList {
    //TODO: understand more. https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--26/
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (prev != null) {
            prev.left = null;
            prev.right = root;
        }

        prev = root;

        /**
         * !!! flatten will change root.right.
         */
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }

    /**
     * 0 ms
     * T = n
     * S = n
     * 可以发现展开的顺序其实就是二叉树的先序遍历。算法和 94 题中序遍历的 Morris 算法有些神似，我们需要两步完成这道题。
     * <p>
     * 将左子树插入到右子树的地方
     * 将原来的右子树接到左子树的最右边节点
     * 考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
     * <p>
     * 作者：windliang
     * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--26/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class Sol_preorder {
        public void flatten(TreeNode root) {
            TreeNode cur = root;

            while (cur != null) {
                //左子树为 null，直接考虑下一个节点
                if (cur.left == null) {
                    cur = cur.right;
                } else {
                    // 找左子树最右边的节点
                    TreeNode pre = cur.left;
                    while (pre.right != null) {
                        pre = pre.right;
                    }
                    //将原来的右子树接到左子树的最右边节点
                    pre.right = cur.right;
                    // 将左子树插入到右子树的地方
                    cur.right = cur.left;
                    cur.left = null;
                    // 考虑下一个节点
                    cur = cur.right;
                }
            }
        }
    }

    private TreeNode prev;

    /**
     * 0 ms
     * T = n
     * S = n
     */
    class Sol_useEnd {
        public void flatten(TreeNode root) {
            convert(root);
        }

        // return last node
        public TreeNode convert(TreeNode root) {
            if (root == null) {
                return root;
            }

            if (root.left == null && root.right == null) {
                return root;
            } else if (root.left == null) {
                TreeNode REnd = convert(root.right);
                return REnd;
            } else if (root.right == null) {
                TreeNode LEnd = convert(root.left);
                root.right = root.left;
                root.left = null;
                return LEnd;
            } else {
                TreeNode LEnd = convert(root.left);
                TreeNode REnd = convert(root.right);

                TreeNode LStart = root.left;
                TreeNode RStart = root.right;

                root.left = null;
                root.right = LStart;
                LEnd.right = RStart;
                return REnd;
            }
        }

    }

    class Sol_iterative_preorder {
        public void flatten_iterative(TreeNode root) {

            Stack<TreeNode> stack = new Stack<>();

            if (root != null) {
                stack.push(root);
            }

            TreeNode prev = null;
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                if (prev != null) {
                    prev.left = null;
                    prev.right = cur;
                }

                prev = cur;
                if (cur.right != null) {
                    stack.push(cur.right);
                }

                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }
    }
}
