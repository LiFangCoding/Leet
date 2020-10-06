package leet._351_400;

import common.ListNode;

import java.util.Random;

public class _382_LinkedList_Random_Node {
    class Solution {
        ListNode h;
        Random rand = new Random();

        /**
         * @param head The linked list's head.
         *             Note that the head is guaranteed to be not null, so it contains at least one node.
         */
        public Solution(ListNode head) {
            h = head;
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom() {
            // cur person. n is current number of people
            int c = -1, n = 0;
            for (ListNode p = h; p != null; p = p.next) {
                n++;
                if (rand.nextInt(n) == 0) {
                    c = p.val;
                }
            }
            return c;
        }
    }
}
