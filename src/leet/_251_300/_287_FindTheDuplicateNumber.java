package leet._251_300;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [3,1,3,4,2]
 * Output: 3
 * Note:
 * <p>
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class _287_FindTheDuplicateNumber {
    /**
     * Sol1: sort and find duplicate
     * Sol2: use set to find the same one
     * Sol3 : think about the slow and fast pointer
     * <p>
     * https://leetcode-cn.com/problems/find-the-duplicate-number/solution/287xun-zhao-zhong-fu-shu-by-kirsche/
     * 142题中慢指针走一步slow = slow.next ==> 本题 slow = nums[slow]
     * 142题中快指针走两步fast = fast.next.next ==> 本题 fast = nums[nums[fast]]
     */
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int pre1 = 0;
        int pre2 = slow;

        while (pre1 != pre2) {
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }

        return pre1;
    }
}
