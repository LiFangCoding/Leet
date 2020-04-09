package _51_100;

import java.util.HashMap;
import java.util.Map;

public class _76_Minimum_Window_Substring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> tmap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tmap.put(c, tmap.getOrDefault(c, 0) + 1);
        }

        char[] chars = s.toCharArray();
        int len = chars.length;
        String ans = "";
        // cnt the occurance of chars
        int cnt = 0;

        Map<Character, Integer> windowMap = new HashMap<>();
        for (int l = 0, r = 0; r < len; r++) {
            if (tmap.containsKey(chars[r])) {
                windowMap.put(chars[r], windowMap.getOrDefault(chars[r], 0) + 1);
                if (windowMap.get(chars[r]) <= tmap.get(chars[r])) {
                    cnt++;
                }

                while (cnt == t.length()) {
                    // here need to find minimum
                    String newAns = s.substring(l, r + 1);
                    if (ans == "" || ans.length() > newAns.length()) {
                        ans = newAns;
                    }

                    if (tmap.containsKey(chars[l])) {
                        if (windowMap.get(chars[l]) <= tmap.get(chars[l])) {
                            cnt--;
                        }

                        windowMap.put(chars[l], windowMap.get(chars[l]) - 1);
                    }

                    l++;
                }
            }
        }

        return ans;
    }
}
