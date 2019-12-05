package _51_100;

public class _55_Jump_Game {
  /**
   * Dynamic Programming
   * O(n^2)
   * @param A
   * @return
   */
  public boolean canJump_dp(int[] A) {
    if (A == null || A.length == 0) {
      return false;
    }

    int len = A.length;
    boolean[] f = new boolean[len];
    f[0] = true;

    for (int i = 1; i < len; i++) {
      for (int j = 0; j < i; j++) {
        if (f[j] && j + A[j] >= i) {
          f[i] = true;
          break;
        }
      }
    }

    return f[len - 1];
  }

  /**
   * Greedy
   * O(n)
   * @return
   */
  public boolean canJump_greedy(int[] A) {
    // think it as merging n intervals
    if (A == null || A.length == 0) {
      return false;
    }
    int farthest = A[0];
    for (int i = 1; i < A.length; i++) {
      if (i > farthest) {
        return false;
      }
      if (i <= farthest && A[i] + i >= farthest) {
        farthest = A[i] + i;
      }
    }
    return farthest >= A.length - 1;
  }

  public static void main(String[] args) {
    _55_Jump_Game test = new _55_Jump_Game();
    int[] A  = new int[]{2,3,1,1,4};
    System.out.println("true " + test.canJump_dp(A));

    A = new int[]{3,2,1,0,4};
    System.out.println("false " + test.canJump_dp(A));
  }
}
