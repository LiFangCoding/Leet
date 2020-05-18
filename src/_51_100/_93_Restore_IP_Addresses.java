package _51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * Example:
 * <p>
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 */
public class _93_Restore_IP_Addresses {
  public static void main(String[] args) {
    _93_Restore_IP_Addresses test = new _93_Restore_IP_Addresses();
    System.out.println(test.restoreIpAddresses("25525511135"));

    System.out.println(Integer.parseInt("01"));
  }

  List<String> ans;
  public List<String> restoreIpAddresses(String s) {
    ans = new ArrayList<>();

    int len = s.length();
    if (len < 4 || len > 12) {
      return ans;
    }

    dfs(s, 0, "", 0);
    return ans;
  }


  // "010010"
  // ["0.1.0.10","0.1.0.10","0.1.1.0","0.10.0.10","0.10.1.0","0.100.1.0","1.0.0.10","1.0.1.0","1.0.1.0","10.0.1.0"]
  // exp : ["0.10.0.10","0.100.1.0"]
  private void dfs(String s, int start, String path, int cnt) {
    if (start == s.length()) {
      if (cnt == 4) {
        ans.add(path.substring(0, path.length() - 1));
      }

      return;
    }

    /**
     * Important prune. Increase from 10% to 90 %
     */
    if (cnt > 4) {
      return;
    }

    for (int i = start; i < start + 4 && i < s.length(); i++) {
      String subS = s.substring(start, i + 1);

      // important to skip the s which start with 0
      //  01 is not correct
      if (subS.length() > 1 && subS.charAt(0) == '0') {
        continue;
      }

      int val = Integer.parseInt(subS);

      if (val >= 0 && val <= 255) {
        dfs(s, i + 1, path + val + ".", cnt + 1);
      }
    }
  }
}
