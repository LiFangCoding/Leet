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
     * T = O(NKlogK), where N is the length of A, and K is the maximum length of a string in A.
     * The outer loop has complexity O(N) as we iterate through each string.
     * Then, we sort each string in O(KlogK) time.
     * S = O(NK), the total information content stored in ans
     *
     * @param A
     * @return
     */
    public List<List<String>> groupAnagrams_hashmap(String[] A) {
        List<List<String>> ans = new ArrayList<>();
        if (A.length == 0) {
            return ans;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s : A) {
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
