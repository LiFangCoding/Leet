package _501_550;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 * <p>
 * Examples 1
 * Input:
 * <p>
 * 5
 * /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * Examples 2
 * Input:
 * <p>
 * 5
 * /  \
 * 2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 */
public class _508_Most_Frequent_Subtree_Sum {

    //sum,value
    int maxCount;
    // sum -> count
    Map<Integer, Integer> map;
    List<Integer> anslist;

    public int[] findFrequentTreeSum(TreeNode root) {
        maxCount = 0;
        map = new HashMap<>();
        anslist = new ArrayList<>();
        getSum(root);

        int[] ans = new int[anslist.size()];
        int i = 0;
        for (int num : anslist) {
            ans[i++] = num;
        }
        return ans;
    }

    // get sum and sum value to the map.
    private int getSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = root.val + getSum(root.left) + getSum(root.right);
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        int count = map.get(sum);
        if (count == maxCount) {
            anslist.add(sum);
        } else if (count > maxCount) {
            maxCount = count;
            anslist.clear();
            anslist.add(sum);
        }
        return sum;
    }
}
