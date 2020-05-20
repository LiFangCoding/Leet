package _1_50;

/**
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 */
public class _11_ContainerWithMostWater {
    /**
     * Brute force
     * T = O(n^2)
     * S = O(1)
     */
    public int maxArea(int[] A) {
        int ans = 0;
        int len = A.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                ans = Math.max(ans, Math.min(A[i], A[j]) * (j - i));
            }
        }
        return ans;
    }

    /**
     * T = O(n)
     * S = O(1)
     */
    public int maxArea2(int[] A) {
      int len = A.length;
      int l = 0, r = len - 1;
      int ans = 0;

      while (l < r) {
        int dis = r - l;
        ans = Math.max(ans, dis * Math.min(A[l], A[r]));

        if (A[l] < A[r]) {
          l++;
        } else if (A[l] > A[r]) {
          r--;
        } else {
          l++;
          r--;
        }
      }

      return ans;
    }
}
