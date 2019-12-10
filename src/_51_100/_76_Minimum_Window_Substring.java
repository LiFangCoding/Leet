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
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int right = 0, j = 0, c = 0; right < s.length(); right++) {
//            if (hash)
        }
        return null;
    }
}
