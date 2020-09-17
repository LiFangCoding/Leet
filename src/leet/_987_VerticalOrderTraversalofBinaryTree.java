package leet;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given a binary tree, return the vertical order traversal of its nodes values.
 * <p>
 * For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).
 * <p>
 * Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).
 * <p>
 * If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.
 * <p>
 * Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.
 */
public class _987_VerticalOrderTraversalofBinaryTree {
    /**
     * x, {y, val}
     */
    Map<Integer, List<Data>> map;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        map = new TreeMap<>();
        dfs(root, 0, 0);
        for (int x : map.keySet()) {
            List<Data> datalist = map.get(x);
            Collections.sort(datalist, (a, b) -> {
                if (a.y != b.y) {
                    return Integer.compare(a.y, b.y);
                } else {
                    return Integer.compare(a.val, b.val);
                }
            });

            List<Integer> temp = new ArrayList<>();
            datalist.forEach(d -> temp.add(d.val));
            res.add(temp);
        }

        return res;
    }

    private void dfs(TreeNode root, int x, int y) {
        if (root == null) {
            return;
        }

        map.putIfAbsent(x, new ArrayList<>());
        map.get(x).add(new Data(y, root.val));

        dfs(root.left, x - 1, y + 1);
        dfs(root.right, x + 1, y + 1);
    }

    public class Data {
        public int y;
        public int val;

        public Data(int y, int val) {
            this.y = y;
            this.val = val;
        }
    }
}
