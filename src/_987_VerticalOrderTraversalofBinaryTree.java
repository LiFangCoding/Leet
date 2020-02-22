import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
    List<Data> datalist;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        datalist = new ArrayList<>();
        dfs(root, 0, 0);

        Collections.sort(
                datalist,
                Comparator.comparing(Data::getX)
                        .thenComparing(Data::getY)
                        .thenComparing(Data::getVal)
        );

        for (int i = 0; i < datalist.size(); i++) {
            Data data = datalist.get(i);
            if (i == 0 || data.x != datalist.get(i - 1).x) {
                List<Integer> temp = new ArrayList<>();
                temp.add(data.val);
                res.add(temp);
            } else {
                res.get(res.size() - 1).add(data.val);
            }
        }

        return res;
    }

    private void dfs(TreeNode root, int x, int y) {
        if (root == null) {
            return;
        }

        datalist.add(new Data(x, y, root.val));
        dfs(root.left, x - 1, y + 1);
        dfs(root.right, x + 1, y + 1);
    }

    // data object which contains x, y, val
    public class Data {
        public int x;
        public int y;
        public int val;

        public Data(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getVal() {
            return val;
        }
    }
}
