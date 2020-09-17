package leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 *
 * Example 1:
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 * Note:
 *
 * S will have length in range [1, 500].
 * S will consist of lowercase letters ('a' to 'z') only.
 */
public class _763_Partition_Labels {
    public List<Integer> partitionLabels(String s) {
        // char c -> last idx
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return ans;
        }

        char[] A = s.toCharArray();
        for (int i = 0; i < A.length; i++) {
            map.put(A[i], i);
        }

        int len = A.length;
        // int r = 0, anchor = 0;

        // for (int i = 0; i < len; i++) {
        //     r = Math.max(r, map.get(A[i]));

        //     if (i == r) {
        //         // here is anchor
        //         ans.add(r - anchor + 1);
        //         anchor = i + 1;
        //     }
        // }

        // return ans;

        int r = 0;
        for (int l = 0; l < len; ) {
            // here is character A[l]. not l
            int endIdx = map.get(A[l]);
            r = Math.max(r, endIdx);

            int start = l;
            while (l < r) {
                l++;
                r = Math.max(r, map.get(A[l]));
            }

            ans.add(r - start + 1);
            // l is not endIdx + 1 here.
            l = l + 1;
        }

        return ans;
    }
}
