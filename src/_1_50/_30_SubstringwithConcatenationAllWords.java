package _1_50;

import java.util.*;

/**
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * Example 2:
 * <p>
 * Input:
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * Output: []
 */
public class _30_SubstringwithConcatenationAllWords {
    //TODO
    /**
     * 8ms
     */
    class Sol_all_words {
        public List<Integer> findSubstring(String s, String[] words) {
            // write your code here
            List<Integer> result = new ArrayList<>();
            if (s == null || s.length() == 0 || words == null || words.length == 0) return result;
            Map<String, Integer> toFind = new HashMap<>();
            for (String word : words) {
                toFind.put(word, toFind.getOrDefault(word, 0) + 1);
            }

            int wordLen = words[0].length(), numWords = words.length;
            for (int offset = 0; offset < wordLen; offset++) {
                helper(s, offset, wordLen, numWords, toFind, result);
            }
            return result;
        }

        private void helper(String s, int offset, int wordLen, int numWords, Map<String, Integer> toFind, List<Integer> result) {
            Map<String, Integer> found = new HashMap<>();
            LinkedList<String> foundWords = new LinkedList<>();
            int n = s.length(), seqLen = wordLen * numWords;
            outter:
            for (int i = offset; i + seqLen <= n; ) {
                while (foundWords.size() < numWords) {
                    int wordIndex = foundWords.size();
                    int wordStart = i + wordIndex * wordLen,
                            wordEnd = i + wordIndex * wordLen + wordLen;
                    String curWord = s.substring(wordStart, wordEnd);
                    if (!toFind.containsKey(curWord)) {
                        found.clear();
                        foundWords.clear();
                        i = wordEnd;
                        continue outter;
                    }

                    foundWords.addLast(curWord);
                    found.put(curWord, found.getOrDefault(curWord, 0) + 1);
                    if (found.get(curWord) <= toFind.get(curWord)) continue;

                    while (found.get(curWord) > toFind.get(curWord)) {
                        String firstWord = foundWords.removeFirst();
                        found.put(firstWord, found.get(firstWord) - 1);
                        i += wordLen;
                    }
                    continue outter;
                }


                result.add(i);
                String firstWord = foundWords.removeFirst();
                found.put(firstWord, found.get(firstWord) - 1);
                i += wordLen;
            }
        }
    }


    /**
     * 122ms
     * https://www.jiuzhang.com/solution/substring-with-concatenation-of-all-words/#tag-highlight
     */
    class Sol_slow {
        public ArrayList<Integer> findSubstring(String S, String[] L) {
            ArrayList<Integer> result = new ArrayList<Integer>();

            if (S == null || L == null || L.length == 0) {
                return result;
            }

            HashMap<String, Integer> toFind = new HashMap<String, Integer>();
            HashMap<String, Integer> found = new HashMap<String, Integer>();
            int m = L.length, n = L[0].length();
            for (int i = 0; i < m; i++) {
                if (!toFind.containsKey(L[i])) {
                    toFind.put(L[i], 1);
                } else {
                    toFind.put(L[i], toFind.get(L[i]) + 1);
                }
            }
            for (int i = 0; i <= S.length() - n * m; i++) {
                found.clear();
                int j;
                for (j = 0; j < m; j++) {
                    int k = i + j * n;
                    String stub = S.substring(k, k + n);
                    if (!toFind.containsKey(stub)) break;
                    if (!found.containsKey(stub)) {
                        found.put(stub, 1);
                    } else {
                        found.put(stub, found.get(stub) + 1);
                    }
                    if (found.get(stub) > toFind.get(stub)) break;
                }
                if (j == m) result.add(i);
            }
            return result;
        }
    }
}
