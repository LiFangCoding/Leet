package _101_150;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * <p>
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * <p>
 * For example, given
 * <p>
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * Return the following binary tree:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {
    /**
     * T = n
     * 递归建立整棵二叉树：先递归创建左右子树，然后创建根节点，并让指针指向两棵子树。
     * <p>
     * 具体步骤如下：
     * <p>
     * 先利用前序遍历找根节点：前序遍历的第一个数，就是根节点的值；
     * 在中序遍历中找到根节点的位置 k，则 k 左边是左子树的中序遍历，右边是右子树的中序遍历；
     * 假设左子树的中序遍历的长度是 l，则在前序遍历中，根节点后面的 l 个数，是左子树的前序遍历，剩下的数是右子树的前序遍历；
     * 有了左右子树的前序遍历和中序遍历，我们可以先递归创建出左右子树，然后再创建根节点；
     * 时间复杂度分析：我们在初始化时，用哈希表(unordered_map<int,int>)记录每个值在中序遍历中的位置，
     * 这样我们在递归到每个节点时，在中序遍历中查找根节点位置的操作，只需要 O(1)的时间。
     * 此时，创建每个节点需要的时间是 O(1)，所以总时间复杂度是 O(n)。
     * <p>
     * 作者：yxc
     * 链接：https://www.acwing.com/solution/content/193/
     * 来源：AcWing
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    // preorder:  root, l, r. we can get part from len
    // inorder: l, root, r
    // val -> idx
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }

        int len1 = preorder.length;
        int len2 = inorder.length;
        if (len1 != len2) {
            return null;
        }

        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, len1 - 1, inorder, 0, len2 - 1);
    }

    private TreeNode helper(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        // cannot ignore. Else index 0 out of bound 0. [], []
        if (l1 > r1) {
            return null;
        }

        // this can ignore and correct val.
        //    if (l1 == r1) {
        //      return new TreeNode(preorder[l1]);
        //    }

        int rootIdx2 = map.get(preorder[l1]);
        int leftDiff = rootIdx2 - 1 - l2;

        TreeNode root = new TreeNode(preorder[l1]);
        root.left = helper(preorder, l1 + 1, l1 + 1 + leftDiff, inorder, l2, rootIdx2 - 1);
        root.right = helper(preorder, l1 + leftDiff + 2, r1, inorder, rootIdx2 + 1, r2);

        return root;
    }
}
