package leet._101_150;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * <p>
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 * <p>
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Output: 5
 * <p>
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 * <p>
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * Output: 0
 * <p>
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class _127_Word_Ladder {
    public static void main(String[] args) {
        //        _127_Word_Ladder test = new _127_Word_Ladder();
        //        System.out.println(new Sol_One_BFS().ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        //        System.out.println(test.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
        //
        //        System.out.println(test.ladderLength_DBFS("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        //        System.out.println(test.ladderLength_DBFS("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
    }

    // https://leetcode-cn.com/problems/word-ladder/solution/suan-fa-shi-xian-he-you-hua-javashuang-xiang-bfs23/
    class Sol_One_BFS {
        Set<String> set;

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            set = new HashSet<>(wordList);

            Queue<String> q = new LinkedList<>();
            Set<String> marked = new HashSet<>();

            if (beginWord != null) {
                q.add(beginWord);
                marked.add(beginWord);
            }

            int level = 0;
            while (!q.isEmpty()) {
                level++;
                int size = q.size();
                while (size-- > 0) {
                    String cur = q.remove();

                    if (cur.equals(endWord)) {
                        return level;
                    }

                    for (String neigh : neighs(cur)) {
                        if (!marked.contains(neigh)) {
                            q.add(neigh);
                            marked.add(neigh);
                        }
                    }
                }
            }

            // here always return ans. If not found, should return 0.
            return 0;
        }

        private List<String> neighs(String s) {
            List<String> ans = new ArrayList<>();

            char[] A = s.toCharArray();
            int len = A.length;

            for (int i = 0; i < len; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == A[i]) {
                        continue;
                    }

                    String nextWord = s.substring(0, i) + c + s.substring(i + 1);
                    if (set.contains(nextWord)) {
                        ans.add(nextWord);
                    }
                }
            }

            return ans;
        }
    }

    //TODO: make it to Double bfs
    public int ladderLength_DBFS(String start, String end, List<String> wordList) {
        Set<String> hash = new HashSet<>(wordList);

        if (!hash.contains(end)) {
            return 0;
        }

        Set<String> head = new HashSet<>();
        Set<String> tail = new HashSet<>();
        head.add(start);
        tail.add(end);

        int res = 2;
        while (head.size() != 0 && tail.size() != 0) {
            if (head.size() > tail.size()) {
                Set<String> temp = head;
                head = tail;
                tail = head;
            }

            Set<String> tmp = new HashSet<>();

            for (String word : head) {
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);

                    for (int j = 0; j < 26; j++) {
                        if ('a' + j == c)
                            continue;
                        StringBuilder sb = new StringBuilder(word);
                        sb.setCharAt(i, (char) ('a' + j));
                        String next = sb.toString();

                        if (tail.contains(next))
                            return res;

                        if (hash.contains(word)) {
                            tmp.add(word);
                            hash.remove(word);
                        }
                    }
                }
            }
            res++;
            Set<String> swaptmp = tmp;
            head = tmp;
            tmp = swaptmp;
        }
        return 0;
    }
}
