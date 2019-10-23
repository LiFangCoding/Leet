import _1_50._23_MergeKSortedLists;
import common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _23_MergeKSortedListsTest {
    _23_MergeKSortedLists test = new _23_MergeKSortedLists();

    @Test
    void mergeKLists1() {
        ListNode l1 = ListNode.stringToListNode("[1,4,5]");
        ListNode l2 = ListNode.stringToListNode("[1,3,4]");
        ListNode l3 = ListNode.stringToListNode("[2,6]");

        ListNode[] lists = {l1, l2, l3};
        assertEquals("1->1->2->3->4->4->5->6", test.mergeKLists1(lists).toString());
    }

    @Test
    void mergeKLists2() {
        ListNode l1 = ListNode.stringToListNode("[1,4,5]");
        ListNode l2 = ListNode.stringToListNode("[1,3,4]");
        ListNode l3 = ListNode.stringToListNode("[2,6]");

        ListNode[] lists = {l1, l2, l3};
        assertEquals("1->1->2->3->4->4->5->6", test.mergeKLists2(lists).toString());
    }

}