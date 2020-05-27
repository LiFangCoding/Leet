package _101_150;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * <p>
 * Return an empty list if there is no such transformation sequence.
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
 * Output:
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * Example 2:
 * <p>
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * Output: []
 * <p>
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class _126_WordLadder2 {
    //TODO
    public List<List<String>> findLadders(String start, String end,
                                          List<String> wordList) {
        Set<String> wordListSet = new HashSet<>(wordList);

        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, Integer> dis = new HashMap<String, Integer>();
        return null;

//        bfs(start, end, wordListSet, dis);
//        if (!dis.containsKey(end)) {
//            return ans;
//        }
//
//        List<String> path = new ArrayList<String>();
//        path.add(start);
//        dfs(start, end, dis, ans, path);
//
//        return ans;
    }

//    private void bfs(String beginWord, String endWord,
//             Set<String> wordListSet,
//             Map<String, Integer> dis) {
//
//        Queue<String> q = new LinkedList<>();
//        q.add(beginWord);
//        dis.put(beginWord, 0);
//        while (!q.isEmpty()) {
//            String sta = q.remove();
//            if (sta == endWord)
//                break;
//            for (int i = 0; i < endWord.length(); i++) {
//                String nxt = sta;
//                for (char c = 'a'; c <= 'z'; c++) {
//                    nxt.charAt(i) = c;
//                    if (wordListSet.find(nxt) == wordListSet.end())
//                        continue;
//                    if (dis.find(nxt) == dis.end()) {
//                        dis[nxt] = dis[sta] + 1;
//                        q.push(nxt);
//                    }
//                }
//            }
//        }
//    }

}
