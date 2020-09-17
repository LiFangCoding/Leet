package leet._351_400;

import common.ListNode;

/**
 * Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.
 * <p>
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * <p>
 * The digits are stored such that the most significant digit is at the head of the list.
 * <p>
 * Example :
 * <p>
 * Input: [1,2,3]
 * Output: [1,2,4]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _369_Plus_One_LinkedList {
    public ListNode plusOne(ListNode head) {
        if (head == null)
            return new ListNode(1);

        ListNode newHead = reverse(head);
        ListNode p = newHead;
        int sum = 1;
        while (p != null && sum != 0) {
            sum += p.val;
            p.val = sum % 10;
            sum = sum / 10;
            if (p.next == null && sum != 0) {
                p.next = new ListNode(sum);
                sum = 0;
            }
            p = p.next;
        }

        return reverse(newHead);
    }

    ListNode reverse(ListNode head) {
        ListNode first = null, second = head;

        while (second != null) {
            ListNode t = second.next;
            second.next = first;
            first = second;
            second = t;
        }
        return first;
    }
}
