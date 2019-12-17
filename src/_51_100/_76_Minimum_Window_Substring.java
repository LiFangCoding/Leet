package _51_100;

import java.util.HashMap;

public class _76_Minimum_Window_Substring {
  /**
   * TODO
   *
   * @param s
   * @param t
   * @return
   */
  public String minWindow(String s, String t) {
    /**
     * c -> i how many needed. If i <= 0, means it is ok
     */
    HashMap<Character, Integer> map = new HashMap<>();
    int count = 0;
    int res = Integer.MIN_VALUE;

    for (char c : t.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    StringBuilder sb = new StringBuilder();
    for (int right = 0, left = 0; right < s.length(); right++) {
      char c = s.charAt(right);

      if (!map.containsKey(c)) {
        continue;
      }

      map.put(c, map.get(c) - 1);

      if (map.get(c) == 0) {
        count++;
        if (count == map.size()) {
          while (left < right) {
            char cleft = s.charAt(left);
            if (!map.containsKey(cleft)) {
              left++;
            }

            map.put(cleft, map.get(cleft) + 1);
            if (map.get(cleft) > 0) {
              count--;
              break;
            } else {
              left++;
            }
          }
        }
      }
    }
    return null;
  }
}
