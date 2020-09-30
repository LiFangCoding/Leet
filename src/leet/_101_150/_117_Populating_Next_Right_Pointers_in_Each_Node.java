package leet._101_150;

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
        if (root == null) return null;

        Node cur = root;
        while (cur != null) {
            // next level head
            Node head = new Node(-1);
            Node tail = head;
            for (Node p = cur; p != null; p = p.next) {
                if (p.left != null) {
                    tail.next = p.left;
                    tail = tail.next;
                }

                if (p.right != null) {
                    tail.next = p.right;
                    tail = tail.next;
                }
            }
            cur = head.next;
        }

        return root;
    }
}
