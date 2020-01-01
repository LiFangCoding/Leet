package _101_150;

import common.Node;

/**
 * Given a binary tree
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
 */
public class _117_Populating_Next_Right_Pointers_in_Each_Node {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        /**
         * !!!levelHead only goes to previous level.
         * Here we will check by the levelHead. If it is last level, it will check all left, right are empty.
         */
        Node levelHead = root;
        while (levelHead != null) {
            Node dummy = new Node(0);
            Node tail = dummy;

            /**
             * traverse next level
             */
            for (Node cur = levelHead; cur != null; cur = cur.next) {
                if (cur.left != null) {
                    tail.next = cur.left;
                    tail = tail.next;
                }

                if (cur.right != null) {
                    tail.next = cur.right;
                    tail = tail.next;
                }
            }

            tail.next = null;
            levelHead = dummy.next;
        }

        return root;
    }
}
