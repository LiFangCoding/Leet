package _201_250;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _248_Strobogrammatic_Num_3 {
  //TODO

  /**
   * 143 ms
   * https://leetcode-cn.com/problems/strobogrammatic-number-iii/solution/fei-chang-jian-dan-qing-xi-de-bfs-by-mike-meng/
   */
  static class Sol_BFS {
    char[] dl = { '0', '1', '6', '8', '9' };
    char[] dr = { '0', '1', '9', '8', '6' };

    public int strobogrammaticInRange(String low, String high) {
      int ans = 0;
      Queue<String> q = new LinkedList<>();
      q.add("");
      q.add("0");
      q.add("1");
      q.add("8");

      while (!q.isEmpty()) {
        String cur = q.remove();

        if (checkValid(cur, low, high)) {
          ans++;
        }

        if (cur.length() > high.length()) {
          continue;
        }

        for (int i = 0; i < 5; ++i) {
          String next = dl[i] + cur + dr[i];
          if (next.length() <= high.length()) {
            q.add(next);
          }
        }
      }

      return ans;
    }

    // large
    private boolean larger(String a, String b) {
      if (a.length() != b.length()) {
        return a.length() > b.length();
      }

      return a.compareTo(b) >= 0;
    }

    private boolean checkValid(String num, String low, String high) {
      if (num.isEmpty() && num.charAt(0) == '0' && num.length() > 1) {
        return false;
      }
      //      boolean lenCorrect = num.length() >= low.length() && num.length() <= high.length();
      return larger(num, low) && larger(high, num);
    }

    public static void main(String[] args) {
      Sol_BFS test = new Sol_BFS();
      System.out.println(test.checkValid("69", "50", "100"));
    }
  }

  /**
   * https://www.jiuzhang.com/solution/strobogrammatic-number-iii/
   */
  class Sol_dfs {
    public int strobogrammaticInRange(String low, String high) {
      // Write your code here
      int count = 0;
      List<String> rst = new ArrayList<String>();
      for (int n = low.length(); n <= high.length(); n++) {
        rst.addAll(helper(n, n));
      }
      for (String num : rst) {
        if ((num.length() == low.length() && num.compareTo(low) < 0) || (num.length() == high.length() && num.compareTo(high) > 0)) {
          continue;
        }
        count++;
      }
      return count;
    }

    private List<String> helper(int cur, int max) {
      if (cur == 0) {
        return new ArrayList<String>(Arrays.asList(""));
      }
      if (cur == 1) {
        return new ArrayList<String>(Arrays.asList("1", "8", "0"));
      }

      List<String> rst = new ArrayList<String>();
      List<String> center = helper(cur - 2, max);

      for (int i = 0; i < center.size(); i++) {
        String tmp = center.get(i);
        if (cur != max) {
          rst.add("0" + tmp + "0");
        }
        rst.add("1" + tmp + "1");
        rst.add("6" + tmp + "9");
        rst.add("8" + tmp + "8");
        rst.add("9" + tmp + "6");
      }
      return rst;
    }
  }
}
