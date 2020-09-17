package leet._301_350;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 * <p>
 * If two nodes are in the same row and column, the order should be from left to right.
 * <p>
 * Examples 1:
 * <p>
 * Input: [3,9,20,null,null,15,7]
 * <p>
 * 3
 * /\
 * /  \
 * 9  20
 * /\
 * /  \
 * 15   7
 * <p>
 * Output:
 * <p>
 * [
 * [9],
 * [3,15],
 * [20],
 * [7]
 * ]
 * Examples 2:
 * <p>
 * Input: [3,9,8,4,0,1,7]
 * <p>
 * 3
 * /\
 * /  \
 * 9   8
 * /\  /\
 * /  \/  \
 * 4  01   7
 * <p>
 * Output:
 * <p>
 * [
 * [4],
 * [9],
 * [3,0,1],
 * [8],
 * [7]
 * ]
 * Examples 3:
 * <p>
 * Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)
 * <p>
 * 3
 * /\
 * /  \
 * 9   8
 * /\  /\
 * /  \/  \
 * 4  01   7
 * /\
 * /  \
 * 5   2
 * <p>
 * Output:
 * <p>
 * [
 * [4],
 * [9,5],
 * [3,0,1],
 * [8,2],
 * [7]
 * ]
 */
public class _314_BinaryTreeVerticalTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        Queue<Data> q = new LinkedList<>();
        if (root != null) {
            q.add(new Data(root, 0));
        }

        while (!q.isEmpty()) {
            Data data = q.remove();
            TreeNode cur = data.node;
            int col = data.col;

            if (!map.containsKey(col)) {
                map.put(col, new ArrayList<>());
            }
            map.get(col).add(cur.val);

            if (cur.left != null) {
                q.add(new Data(cur.left, col - 1));
            }

            if (cur.right != null) {
                q.add(new Data(cur.right, col + 1));
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (List<Integer> list : map.values()) {
            ans.add(list);
        }

        return ans;
    }

    class Data {
        TreeNode node;
        int col;

        public Data(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }
}
