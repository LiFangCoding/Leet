package _101_150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

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

  /**
   * Has isssue
   * https://www.jiuzhang.com/solution/word-ladder-ii/#tag-other-lang-java
   */
  class Sol_revised {
    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
      // write your code here
      HashSet dict = new HashSet<>(wordList);
      if (!dict.contains(end)) {
        return new ArrayList<>();
      }

      dict.add(start);
      dict.add(end);
      Map<String, Set<String>> forwardGraph = new HashMap<>();
      distToEnd(end, dict, forwardGraph);
      List<List<String>> results = new ArrayList<>();
      dfs(start, end, new ArrayList<>(), results, forwardGraph);
      return results;
    }

    private void dfs(String start, String end, List<String> path, List<List<String>> results, Map<String, Set<String>> graph) {
      path.add(start);
      if (start == end) {
        results.add(new ArrayList<>(path));
      } else {
        for (String next : graph.get(start)) {
          dfs(next, end, path, results, graph);
        }
      }
      path.remove(path.size() - 1);
    }

    private void distToEnd(String start, Set<String> dict, Map<String, Set<String>> forwardGraph) {
      Map<String, Integer> dists = new HashMap<>(); // shortest distance to end
      Queue<String> queue = new LinkedList<>();
      dists.put(start, 0);
      queue.offer(start);
      while (!queue.isEmpty()) {
        String curr = queue.poll();
        int dist = dists.get(curr) + 1;
        for (String next : expand(curr, dict)) {
          if (!dists.containsKey(next)) { // not visited so far
            queue.offer(next);
          }
          if (!dists.containsKey(next) || dists.get(next) == dist) {//has not been visited or visited from the current level -- meaning it is on the shortest paths
            dists.put(next, dist);
            if (!forwardGraph.containsKey(next)) {
              forwardGraph.put(next, new HashSet<>());
            }
            forwardGraph.get(next).add(curr);
          }
        }
      }
    }

    private Set<String> expand(String word, Set<String> dict) {
      Set<String> results = new HashSet<>();
      for (int i = 0; i < word.length(); i++) {
        for (char c = 'a'; c <= 'z'; c++) {
          if (word.charAt(i) != c) {
            String newWord = word.substring(0, i) + c + word.substring(i + 1);
            if (dict.contains(newWord)) {
              results.add(newWord);
            }
          }
        }
      }
      return results;
    }
  }

  /**
   *
   */
  class Sol_bfs_dfs {
    List<String> path;
    List<List<String>> ans;
    Set<String> dict;
    Map<String, Integer> distance;

    public List<List<String>> findLadders(String start, String end, List<String> wordList) {
      path = new ArrayList<>();
      ans = new ArrayList<>();

      dict = new HashSet<>(wordList);
      if (!dict.contains(end)) {
        return ans;
      }

      // string -> neighbor
      Map<String, List<String>> neighMap = new HashMap<>();
      distance = new HashMap<>();
      dict.add(start);

      bfs(neighMap, distance, end, start, dict);
      dfs(ans, path, start, end, distance, neighMap);

      return ans;
    }

    void dfs(List<List<String>> ladders, List<String> path, String crt, String end, Map<String, Integer> distance, Map<String, List<String>> map) {
      path.add(crt);

      if (crt.equals(end)) {
        ladders.add(new ArrayList<String>(path));
      } else {
        for (String next : map.get(crt)) {
          if (distance.containsKey(next) && distance.get(crt) == distance.get(next) + 1) {
            dfs(ladders, path, next, end, distance, map);
          }
        }
      }

      path.remove(path.size() - 1);
    }

    void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String start, String end, Set<String> dict) {
      Queue<String> q = new LinkedList<String>();
      q.offer(start);
      distance.put(start, 0);

      for (String s : dict) {
        map.put(s, new ArrayList<String>());
      }

      while (!q.isEmpty()) {
        String crt = q.poll();

        List<String> nextList = expand(crt, dict);
        for (String next : nextList) {
          map.get(next).add(crt);
          if (!distance.containsKey(next)) {
            distance.put(next, distance.get(crt) + 1);
            q.offer(next);
          }
        }
      }
    }

    List<String> expand(String s, Set<String> dict) {
      List<String> expansion = new ArrayList<String>();

      for (int i = 0; i < s.length(); i++) {
        for (char c = 'a'; c <= 'z'; c++) {
          if (c != s.charAt(i)) {
            String expanded = s.substring(0, i) + c + s.substring(i + 1);
            if (dict.contains(expanded)) {
              expansion.add(expanded);
            }
          }
        }
      }

      return expansion;
    }
  }
}
