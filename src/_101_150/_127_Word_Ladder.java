package _101_150;

import java.util.*;

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
        _127_Word_Ladder test = new _127_Word_Ladder();
        System.out.println(test.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(test.ladderLength("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));

        System.out.println(test.ladderLength_DBFS("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(test.ladderLength_DBFS("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log")));
    }

    public int ladderLength(String start, String end, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);

        if (start.equals(end)) {
            return 1;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        /**
         * !!! Initialize
         */
        visited.add(start);
        q.add(start);

        int length = 1;
        while (!q.isEmpty()) {            //开始bfs
            length++;
            int size = q.size();
            for (int i = 0; i < size; i++) {        //枚举当前步数队列的情况
                String word = q.remove();
                for (String nextWord : getNextWords(word, dict)) {
                    if (visited.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return length;
                    }

                    visited.add(nextWord);                //存入新单词
                    q.offer(nextWord);
                }
            }
        }

        return 0;
    }

    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {                    //枚举替换字母
                //枚举替换位置
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = word.substring(0, i) + c + word.substring(i + 1);
                if (dict.contains(nextWord)) {                //如果dict中包含新单词，存入nextWords
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;                                    //构造当前单词的全部下一步方案
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
                        if ('a' + j == c) continue;
                        StringBuilder sb = new StringBuilder(word);
                        sb.setCharAt(i, (char) ('a' + j));
                        String next = sb.toString();

                        if (tail.contains(next)) return res;

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
