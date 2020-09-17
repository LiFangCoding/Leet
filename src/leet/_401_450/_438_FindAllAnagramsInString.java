package leet._401_450;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _438_FindAllAnagramsInString {

    /**
     * 34ms
     * T = n
     * S = n
     */
    public List<Integer> findAnagrams(String s, String p) {
        // this is anagrams. So the len is same with p
        List<Integer> ans = new ArrayList<>();

        char[] A = s.toCharArray();
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) {
            return ans;
        }

        // char freq. For each character, how many need to find
        Map<Character, Integer> map = new HashMap<>();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int matched = 0;
        // need a sliding window size is pLen
        int l = 0;
        for (int r = 0; r < sLen; r++) {
            if (map.containsKey(A[r])) {
                map.put(A[r], map.get(A[r]) - 1);

                if (map.get(A[r]) >= 0) {
                    matched++;
                }
            }

            if (r - l + 1 == pLen) {
                if (matched == pLen) {
                    ans.add(l);
                }
                // here always need to remove the left. N
                // no need else here
                if (map.containsKey(A[l])) {
                    map.put(A[l], map.get(A[l]) + 1);
                    if (map.get(A[l]) > 0) {
                        matched--;
                    }
                }
                l++;
            }
        }

        return ans;
    }
}
