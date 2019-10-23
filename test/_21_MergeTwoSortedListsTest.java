import _1_50._21_MergeTwoSortedLists;
import common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _21_MergeTwoSortedListsTest {
    _21_MergeTwoSortedLists test = new _21_MergeTwoSortedLists();

    @Test
    void mergeTwoLists() {
        ListNode l1 =  ListNode.stringToListNode("[1,2,4]");
        ListNode l2 =  ListNode.stringToListNode("[1,3,4]");
        assertEquals("1->1->2->3->4->4", test.mergeTwoLists(l1, l2).toString());

    }
}