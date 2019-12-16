package _51_100;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class _95_Unique_Binary_Search_Trees2 {
    public List<TreeNode> generateTrees(int n) {
        /**
         * 1,2...n
         * Find the root.
         * Then 1 ->  root - 1, generate left search
         * root + 1 -> n, generate right
         */
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> res = new ArrayList<>();

        if (start > end) {
            res.add(null);
            return res;
        }

        if (start == end) {
            res.add(new TreeNode(start));
            return res;
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generateTrees(start, i - 1);
            List<TreeNode> right = generateTrees(i + 1, end);

            for (TreeNode node1 : left) {
                for (TreeNode node2 : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = node1;
                    root.right = node2;
                    res.add(root);
                }
            }
        }

        return res;
    }
}
