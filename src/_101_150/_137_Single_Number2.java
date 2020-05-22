package _101_150;

/**
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,3,2]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 */
public class _137_Single_Number2 {
    public static void main(String[] args) {
        _137_Single_Number2 test = new _137_Single_Number2();
        System.out.println(test.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));

        System.out.println(1 ^ 1);
        System.out.println(1 ^ 0);
      System.out.println(0 ^ 1);
      System.out.println(0 ^ 0);

      System.out.println("|");
      System.out.println(1 | 1);
      System.out.println(1 | 0);
      System.out.println(0 | 1);
      System.out.println(0 | 0);
    }

  /**
   * T = n. 仅遍历 32 次数组，故时间复杂度为 O(n), n is the array length。
   * S = 1
   * 根据 Single Number 的做法，可以推广到更一般的问题。
   * 考虑二进制每一位上出现 0 和 1 的次数，如果出现 1 的次数为 3k + 1，则证明答案中这一位是 1。
   */
  public int singleNumber(int[] A) {
    int ans = 0;

    int size = 32;
    for (int i = 0; i < size; i++) {
      int cnt = 0;
      for (int num : A) {
        cnt += ((num >> i) & 1);
      }

      cnt %= 3;
      ans += cnt << i;
    }

    return ans;
  }
}
