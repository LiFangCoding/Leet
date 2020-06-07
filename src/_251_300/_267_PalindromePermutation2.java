package _251_300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.
 * <p>
 * Example 1:
 * <p>
 * Input: "aabb"
 * Output: ["abba", "baab"]
 * Example 2:
 * <p>
 * Input: "abc"
 * Output: []
 */
public class _267_PalindromePermutation2 {
    /**
     * 14ms
     * https://www.jiuzhang.com/solution/palindrome-permutation-ii/#tag-highlight-lang-java
     */
    List<String> ans;
    Map<Character, Integer> map;

    public List<String> generatePalindromes(String s) {
        int odd = 0;
        String mid = "";
        ans = new ArrayList<>();
        map = new HashMap<>();

        // step 1. build character count map and count odds
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
            odd += map.get(c) % 2 != 0 ? 1 : -1;
        }

        // cannot form any palindromic string
        if (odd > 1) {
            return ans;
        }

        List<Character> list = new ArrayList<>();
        // step 2. add half count of each character to list
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();

            if (val % 2 != 0) {
                mid += key;
            }

            for (int i = 0; i < val / 2; i++) {
                list.add(key);
            }
        }

        // step 3. generate all the permutations
        getPerm(list, mid, new boolean[list.size()], new StringBuilder());

        return ans;
    }

    // generate all unique permutation from list
    void getPerm(List<Character> list, String mid, boolean[] used, StringBuilder sb) {
        if (sb.length() == list.size()) {
            // form the palindromic string
            ans.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            // avoid duplication
            if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) {
                continue;
            }

            if (!used[i]) {
                used[i] = true;
                sb.append(list.get(i));
                // recursion
                getPerm(list, mid, used, sb);
                // backtracking
                used[i] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}

