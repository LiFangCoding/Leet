package leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1002_Find_Common_Characters {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();

        String t = A[0];
        for (int i = 1; i < A.length; i++) {
            t = common(A[i], t);
            if (t.length() == 0) {
                return new ArrayList<>();
            }
        }

        for (char c : t.toCharArray()) {
            res.add(String.valueOf(c));
        }
        return res;
    }

    private String common(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : s2.toCharArray()) {
            if (map.containsKey(c) && map.get(c) > 0) {
                sb.append(c);
                map.put(c, map.get(c) - 1);
            }
        }
        return sb.toString();
    }
}
