package leet._101_150;

import random.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * <p>
 * Return a deep copy of the list.
 * <p>
 * The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 * <p>
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.
 */
public class _138_Copy_List_with_Random_Pointer {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();
        Node cur = head;
        map.put(cur, new Node(cur.val));

        while (cur != null) {
            Node next = cur.next;
            Node random = cur.random;

            if (next != null) {
                if (!map.containsKey(next)) {
                    map.put(next, new Node(next.val));
                }
                map.get(cur).next = map.get(cur.next);
            }

            if (random != null) {
                if (!map.containsKey(random)) {
                    map.put(random, new Node(random.val));
                }
                map.get(cur).random = map.get(random);
            }

            cur = cur.next;
        }

        return map.get(head);
    }

    class Sol_clear_slow_performance {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return null;
            }

            Map<Node, Node> cloneMap = new HashMap<>();

            Node cur = head;
            while (cur != null) {
                cloneMap.put(cur, new Node(cur.val));
                cur = cur.next;
            }

            cur = head;
            while (cur != null) {
                Node cloneNode = cloneMap.get(cur);

                cloneNode.next = cur.next == null ? null : cloneMap.get(cur.next);
                cloneNode.random = cur.random == null ? null : cloneMap.get(cur.random);

                cur = cur.next;
            }

            return cloneMap.get(head);
        }
    }
}
