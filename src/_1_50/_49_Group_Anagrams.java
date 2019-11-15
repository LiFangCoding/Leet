package _1_50;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
public class _49_Group_Anagrams {
    /**
     * T = O(NKlogK), where N is the length of strs, and K is the maximum length of a string in strs.
     * The outer loop has complexity O(N) as we iterate through each string.
     * Then, we sort each string in O(KlogK) time.
     * S = O(NK), the total information content stored in ans
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams_hashmap(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) {
            return res;
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList(map.values());
    }

}
