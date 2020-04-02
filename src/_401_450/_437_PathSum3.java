package _401_450;

import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * ou are given a binary tree in which each node contains an integer value.
 * <p>
 * Find the number of paths that sum to a given value.
 * <p>
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * <p>
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * <p>
 * Example:
 * <p>
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * <p>
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * <p>
 * Return 3. The paths that sum to 8 are:
 * <p>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class _437_PathSum3 {
    class O_N {
        int ans;
        Map<Integer, Integer> map;

        public int pathSum(TreeNode root, int sum) {
            ans = 0;
            map = new HashMap<>();
            map.put(0, 1);

            pathSum(root, 0, sum);
            return ans;
        }

        void pathSum(TreeNode root, int cur, int sum) {
            if (root == null) {
                return;
            }

            cur += root.val;
            ans += map.getOrDefault((cur - sum), 0);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            pathSum(root.left, cur, sum);
            pathSum(root.right, cur, sum);
            //记得回溯，把路径和弹出去.
            // Because the path can change to anotehr one
            map.put(cur, map.get(cur) - 1);
        }
    }

    class O_N2 {
        public int pathSum(TreeNode root, int sum) {
            if (root == null) {
                return 0;
            }

            return pathSum(root.left, sum) + pathSum(root.right, sum) + getPath(root, sum);
        }

        private int getPath(TreeNode root, int sum) {
            if (root == null) {
                return 0;
            }
            int ans = 0;

            if (root.val == sum) {
                ans += 1;
            }

            ans += getPath(root.left, sum - root.val);
            ans += getPath(root.right, sum - root.val);

            return ans;
        }
    }
}
