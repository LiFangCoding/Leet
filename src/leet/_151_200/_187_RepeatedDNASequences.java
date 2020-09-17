package leet._151_200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * <p>
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * <p>
 * Example:
 * <p>
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * <p>
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 */
public class _187_RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();

        int len = s.length();
        List<String> res = new ArrayList<>();

        for (int l = 0, r = 9; r < len; l++, r++) {
            String substring = s.substring(l, r + 1);
            if (map.containsKey(substring)) {
                /**
                 * Only when it appear one time, add it to avoid duplicate
                 */
                if (map.get(substring) == 1) {
                    res.add(substring);
                    map.put(substring, map.get(substring) + 1);
                }
            } else if (!map.containsKey(substring)) {
                map.put(substring, 1);
            }
        }

        return res;
    }
}
