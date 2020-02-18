import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two binary search trees root1 and root2.
 * <p>
 * Return a list containing all the integers from both trees sorted in ascending order.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root1 = [2,1,4], root2 = [1,0,3]
 * Output: [0,1,1,2,3,4]
 * Example 2:
 * <p>
 * Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * Output: [-10,0,0,1,2,5,7,10]
 * Example 3:
 * <p>
 * Input: root1 = [], root2 = [5,1,7,0,2]
 * Output: [0,1,2,5,7]
 * Example 4:
 * <p>
 * Input: root1 = [0,-10,10], root2 = []
 * Output: [-10,0,10]
 * Example 5:
 * <p>
 * <p>
 * Input: root1 = [1,null,8], root2 = [8,1]
 * Output: [1,1,8,8]
 *  
 * <p>
 * Constraints:
 * <p>
 * Each tree has at most 5000 nodes.
 * Each node's value is between [-10^5, 10^5].
 */
public class _1305_AllElementsinTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        inorder(root1, list1);
        inorder(root2, list2);

        List<Integer> res = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                res.add(list1.get(i++));
            } else {
                res.add(list2.get(j++));
            }
        }

        while (i < list1.size()) {
            res.add(list1.get(i++));
        }

        while (j < list2.size()) {
            res.add(list2.get(j++));
        }

        return res;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}
