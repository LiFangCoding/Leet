package _301_350;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * <p>
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * <p>
 * Example:
 * <p>
 * Given nums = [1, 3, 5]
 * <p>
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * Note:
 * <p>
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-mutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _307_Range_Sum_Query_Mutable {
  /**
   * 13ms
   * T = n + Q*logn
   * S = n
   * 初始化时间复杂度为 O(n)，每次更新或查询操作的时间复杂度为 O(logn)，故总时间复杂度为 O(n+Qlogn)。
   * 使用 Binary Indexed Tree（树状数组）
   * https://www.jiuzhang.com/problem/range-sum-query-mutable/
   * https://www.acwing.com/solution/content/342/
   */
  class NumArray {
    private int[] arr, bit;

    /**
     * @return: nothing
     */
    public NumArray(int[] nums) {
      arr = new int[nums.length];
      bit = new int[nums.length + 1];

      for (int i = 0; i < nums.length; i++) {
        update(i, nums[i]);
      }
    }

    public void update(int index, int val) {
      int delta = val - arr[index];
      arr[index] = val;

      for (int i = index + 1; i <= arr.length; i = i + lowbit(i)) {
        bit[i] += delta;
      }
    }

    public int getPrefixSum(int index) {
      int sum = 0;
      for (int i = index + 1; i > 0; i = i - lowbit(i)) {
        sum += bit[i];
      }
      return sum;
    }

    private int lowbit(int x) {
      return x & (-x);
    }

    public int sumRange(int left, int right) {
      return getPrefixSum(right) - getPrefixSum(left - 1);
    }
  }
}
