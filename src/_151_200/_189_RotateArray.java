package _151_200;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 *
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 *
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 *
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class _189_RotateArray {
  public void rotate_circular_array(int[] A, int k) {
    if (A == null || A.length == 0) {
      return;
    }

    int len = A.length;
    k %= len;

    int count = 0;
    for (int i = 0; count < len; i++) {
      int cur = i;
      int prev = A[i];
      do {
        int next = (cur + k) % len;
        int temp = A[next];
        A[next] = prev;
        prev = temp;
        cur = next;
        count++;
      } while (i != cur);
    }
  }


  /**
   * Use reverse method
   */
  public void rotate(int[] A, int k) {
    if (A == null || A.length == 0) {
      return;
    }

    int len = A.length;
    k %= len;

    reverse(A, 0, len - k -1);
    reverse(A, len - k, len - 1);
    reverse(A, 0, len - 1);
  }

  private void reverse(int[] A, int l, int r) {
    for (; l < r; l++, r--) {
      int temp = A[l];
      A[l] = A[r];
      A[r] = temp;
    }
  }
}
