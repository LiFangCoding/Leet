package _301_350;

import java.util.Stack;

/**
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 * <p>
 * Example 1:
 * <p>
 * Input: "bcabc"
 * Output: "abc"
 * Example 2:
 * <p>
 * Input: "cbacdcbc"
 * Output: "acdb"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _316_Remove_Duplicate_letters {
  /**
   * 10ms
   * T = n
   * 用一个栈来维护答案，从左往右扫描字符串，当栈顶元素字典序小于当前扫描的字符，
   * 并且栈顶元素在s未被扫描到的部分中还有出现时，栈顶元素出栈，并继续比较新的栈顶元素与当前字符字符，
   * 重复上面的过程，直到不符合上述条件时，再让当前字符入栈。最后答案就是栈底到栈顶元素组成的字符串。
   */
  Stack<Integer> S = new Stack();
  boolean vis[] = new boolean[26];
  int num[] = new int[26];

  public String removeDuplicateLetters(String s) {
    // write your code here
    for (int i = 0; i < s.length(); ++i) {
      num[s.charAt(i) - 'a']++;
    }
    for (int i = 0; i < s.length(); ++i) {
      int id = s.charAt(i) - 'a';
      num[id]--;
      if (vis[id])
        continue;
      while (!S.isEmpty() && S.peek() > id && num[S.peek()] > 0) {
        vis[S.peek()] = false;
        S.pop();
      }
      S.push(id);
      vis[id] = true;
    }
    String ans = "";
    for (int x : S) {
      ans += (char) ('a' + x);
    }
    return ans;
  }
}
