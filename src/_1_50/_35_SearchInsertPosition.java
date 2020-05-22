package _1_50;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 * <p>
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 * <p>
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 * <p>
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class _35_SearchInsertPosition {
  /**
   * T = O(log n)
   * S = O(1)
   * Find the first num that is larger than or equal with val. The index is the res.
   * If not exist, return array len.
   */
  public int searchInsert(int[] A, int target) {
    // find first position >= val
    if (A == null || A.length == 0) {
      return 0;
    }

    int l = 0;
    int r = A.length - 1;

    while (l + 1 < r) {
      int mid = l + (r - l) / 2;

      if (A[mid] < target) {
        l = mid;
      } else {
        r = mid;
      }
    }

    if (A[l] >= target) {
      return l;
    }

    if (A[r] >= target) {
      return r;
    }

    return r + 1;
  }
}
