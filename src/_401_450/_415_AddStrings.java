package _401_450;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _415_AddStrings {

  /**
   * 2ms
   * T = n
   * S = n
   */
  class Sol_Directly {
    public String addStrings(String s1, String s2) {
      // A1 is char array of s1
      char[] A1 = s1.toCharArray();
      char[] A2 = s2.toCharArray();

      int idx1 = A1.length - 1;
      int idx2 = A2.length - 1;

      // need reverse to be ans
      StringBuilder sb = new StringBuilder();

      int carry = 0;
      while (idx1 >= 0 || idx2 >= 0 || carry == 1) {
        int sum = carry;

        if (idx1 >= 0) {
          sum += A1[idx1--] - '0';
        }

        if (idx2 >= 0) {
          sum += A2[idx2--] - '0';
        }

        int digit = sum % 10;
        carry = sum / 10;

        sb.append((char) ('0' + digit));
      }

      // sb.reverse() is stringbuilder. sb cannot convert to string
      return sb.reverse().toString();
    }
  }

  /**
   * 3ms
   * T = n
   * S= n
   */
  class Sol_ReverseInt {
    int LEN;

    public String addStrings(String s1, String s2) {
      if (s1 == null || s1.length() == 0) {
        return s2;
      }

      if (s2 == null || s2.length() == 0) {
        return s1;
      }

      LEN = Math.max(s1.length(), s2.length()) + 3;
      int[] A1 = reverseInt(s1);
      int[] A2 = reverseInt(s2);

      int[] c = new int[LEN];
      for (int i = 0; i < LEN; i++) {
        // here need c[i]+= A1[i] + A2[i]. since the c[i] will have carry 1. cannot reset to 0
        c[i] += A1[i] + A2[i];
        // here is >= 10 not > 10
        if (c[i] >= 10) {
          c[i + 1] += c[i] / 10;
          c[i] = c[i] % 10;
        }
      }

      // reverse from last to end
      int i;
      for (i = LEN - 1; i >= 1; --i)
        if (c[i] != 0)
          break;

      StringBuilder sb = new StringBuilder();
      for (; i >= 0; --i)
        sb.append(c[i]);
      return sb.toString();
    }

    private int[] reverseInt(String s) {
      // System.out.println("the string is " + s);
      int[] ans = new int[LEN];
      int len = s.length();

      for (int i = 0; i < len; i++) {
        ans[len - i - 1] = s.charAt(i) - '0';
      }

      return ans;
    }
  }
}
