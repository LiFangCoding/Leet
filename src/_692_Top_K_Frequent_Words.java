import java.util.*;

/**
 * Given a non-empty list of words, return the k most frequent elements.
 * <p>
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 * <p>
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 * with the number of occurrence being 4, 3, 2 and 1 respectively.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 */
public class _692_Top_K_Frequent_Words {
    public static class Sol_PQ {
        /**
         * nlogk
         * n
         */
        public List<String> topKFrequent(String[] words, int k) {
            List<String> ans = new ArrayList<>();

            // string, freq
            // if map need the sort. can consider Use treeMap
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }

            // top k largetst and so on. So if small, remove out.  minpq. freq small to high. word higher to lower
            PriorityQueue<String> minPq = new PriorityQueue<>((x, y) -> {
                if (!map.get(x).equals(map.get(y))) {
                    return Integer.compare(map.get(x), map.get(y));
                } else {
                    return y.compareTo(x);
                }
            });

            // here is set
            for (String word : map.keySet()) {
                minPq.add(word);
                if (minPq.size() > k) {
                    minPq.remove();
                }
            }

            // This cannot make sure the correct order
            // for (String s : minPq) {
            //     ans.add(s);
            // }

            while (!minPq.isEmpty()) {
                ans.add(minPq.remove());
            }

            Collections.reverse(ans);
            return ans;
        }
    }

    /**
     * nlogn
     * n
     */
    public static class Solution_sort {
        public List<String> topKFrequent(String[] words, int k) {
            // string, freq
            // if map need the sort. can consider Use treeMap
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }

            List<String> candidates = new ArrayList<>(map.keySet());

            // need to collection sort by freqs
            // Requirement: frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
            Collections.sort(candidates, (x, y) -> {
                if (!map.get(x).equals(map.get(y))) {
                    return Integer.compare(map.get(y), map.get(x));
                } else {
                    return x.compareTo(y);
                }
                // error: ';' expected
            });

            // System.out.printf("array is %s", Arrays.toString(words));

            // !!! here important one. ["i", "love", "leetcode", "i", "love", "coding"]
            // 2
            // ["love","love"]  expected: ["i","love"]
            // ans res is the word without same. words contains duplicate
            return new ArrayList<>(candidates.subList(0, k));
        }
    }
}
