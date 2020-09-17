import leet._1_50._2_AddTwoNumbers;
import common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class _2_AddTwoNumbersTest {

    @Test
    void addTwoNumbers() {
        ListNode l1 = ListNode.stringToListNode("[2,4,3]");
        ListNode l2 = ListNode.stringToListNode("[5,6,4]");
        System.out.println(l1.toString());

      assertEquals("7->0->8", _2_AddTwoNumbers.addTwoNumbers(l1, l2).toString());
    }
}