package _301_350;

/**
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * <p>
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * <p>
 * Note:
 * <p>
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * Example:
 * <p>
 * Input: [3,1,5,8]
 * Output: 167
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *              coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _312_Burst_Balloons {
  /**
   * (动态规划) O(n3)
   * 状态： dp[i][j]表示戳爆从第ii到第jj个气球得到的最大金币数。
   * <p>
   * 状态转移方程： dp[i][j]=max(dp[i][j],dp[i][k−1]+num[i−1]∗nums[k]∗nums[j+1]+dp[k+1][j])
   * 其中，kk可以理解成[i,j]范围里最后戳破的一个气球。
   * <p>
   * 时间复杂度O(n3): 三层循环
   * <p>
   * 空间复杂度O(n2): dp[i][j]dp[i][j]数组的大小是(n+2)∗(n+2)
   * <p>
   * 作者：extrovert
   * 链接：https://www.acwing.com/solution/content/297/
   * 来源：AcWing
   * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
   *
   * @param nums
   * @return
   */
  public int maxCoins(int[] nums) {
    int len = nums.length;

    int[] A = new int[len + 2];
    for (int i = 0; i < A.length; i++) {
      if (i == 0 || i == A.length - 1) {
        A[i] = 1;
      } else {
        A[i] = nums[i - 1];
      }
    }

    int[][] f = new int[len + 2][len + 2];

    for (int size = 1; size <= len; size++) {
      for (int i = 1; i <= len - size + 1; i++) {
        int j = i + size - 1;
        for (int k = i; k <= j; k++) {
          f[i][j] = Math.max(f[i][j], f[i][k - 1] + A[i - 1] * A[k] * A[j + 1] + f[k + 1][j]);
        }
      }
    }

    return f[1][len];
  }
}
