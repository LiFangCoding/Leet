package _51_100;

public class _53_Maximum_Subarray {
  /**
   * [-2,1,-3,4,-1,2,1,-5,4]
   * 6
   * [4,-1,2,1] has the largest sum = 6.
   * @param A
   * @return
   */
  public int maxSubArray(int[] A) {
    if (A == null || A.length == 0) {
      return 0;
    }

    /**
     * f[i] is the maxSubArray end with ith num.
     * f[i] = Math.max(f[i - 1] + A[i], A[i])
     * res = Math.max(f[i])  i >= 0 && < n
     *
     */
    int len = A.length;
    int[] f = new int[len];
    f[0] = A[0];
    // cannot use 0 here. Since f[0] can be negative.
    int res = f[0];

    for (int i = 1; i < len; i++) {
      f[i] = Math.max(f[i - 1] + A[i], A[i]);
      res = Math.max(f[i], res);
    }

    return res;
  }

  public static void main(String[] args) {
    _53_Maximum_Subarray test = new _53_Maximum_Subarray();
    int[] A = {-2,1,-3,4,-1,2,1,-5,4};
    System.out.println(test.maxSubArray(A));

    A = new int[] { -1, -2 };
    System.out.println(test.maxSubArray(A));

    A = new int[] {-2, -1};
    System.out.println(test.maxSubArray(A));
  }
}
