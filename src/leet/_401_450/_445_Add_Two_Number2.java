package leet._401_450;

import common.ListNode;

import java.util.Stack;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * <p>
 * Example:
 * <p>
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
public class _445_Add_Two_Number2 {
    // 123  +  1 = 124
    // revrse 321  1
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rl1 = reverse(l1);
        ListNode rl2 = reverse(l2);

        ListNode rHead = addTwoList(rl1, rl2);
        return reverse(rHead);
    }

    public ListNode addTwoNumbers_stack(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        ListNode cur = null;

        int carry = 0;
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            int sum = 0;

            if (!s1.isEmpty()) {
                sum += s1.pop();
            }

            if (!s2.isEmpty()) {
                sum += s2.pop();
            }

            sum += carry;
            carry = sum / 10;
            sum %= 10;

            ListNode newHead = new ListNode(sum);
            newHead.next = cur;
            cur = newHead;
        }

        return cur;
    }

    private ListNode addTwoList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;
            sum %= 10;

            cur.next = new ListNode(sum);
            cur = cur.next;
        }

        return dummy.next;
    }

    // no empty l
    // 1->2 -> 3 = 3 -> 2 -> 1
    private ListNode reverse(ListNode l) {
        // prev will be the tail
        ListNode prev = null;
        ListNode cur = l;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            // !! need check
            cur = temp;
        }

        return prev;
    }

}
