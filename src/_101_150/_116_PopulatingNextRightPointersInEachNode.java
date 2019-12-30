package _101_150;

import common.Node;

/**
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * <p>
 * <p>
 * Follow up:
 * <p>
 * You may only use constant extra space.
 * Recursive approach is fine, you may assume implicit stack space does not count as extra space for this problem.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 */
public class _116_PopulatingNextRightPointersInEachNode {
    public Node connect(Node root) {
        /**
         * !!! level.left != null.
         */
        for (Node level = root; level != null && level.left != null; level = level.left) {
            for (Node cur = level; cur != null; cur = cur.next) {
                cur.left.next = cur.right;
                if (cur.next == null) {
                    cur.right.next = null;
                } else {
                    cur.right.next = cur.next.left;
                }
            }
        }

        return root;
    }
}
