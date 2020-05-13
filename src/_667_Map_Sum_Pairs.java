import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implement a MapSum class with insert, and sum methods.
 *
 * For the method insert, you'll be given a pair of (string, integer). The string represents the key and the integer represents the value. If the key already existed, then the original key-value pair will be overridden to the new one.
 *
 * For the method sum, you'll be given a string representing the prefix, and you need to return the sum of all the pairs' value whose key starts with the prefix.
 *
 * Example 1:
 * Input: insert("apple", 3), Output: Null
 * Input: sum("ap"), Output: 3
 * Input: insert("app", 2), Output: Null
 * Input: sum("ap"), Output: 5
 */
public class _667_Map_Sum_Pairs {
  public static void main(String[] args) {
    _667_Map_Sum_Pairs test = new _667_Map_Sum_Pairs();
    test.insert("apple", 3);
    // 3
    test.sum("ap");
    test.insert("app", 2);
    // 2
    test.sum("ap");
  }
  TrieTree trietree;
  Map<String, Integer> map;

  /** Initialize your data structure here. */
  public _667_Map_Sum_Pairs() {
    trietree = new TrieTree();
    map = new HashMap<>();
  }

  public void insert(String key, int val) {
    trietree.insert(key);
    map.put(key, val);
  }

  public int sum(String prefix) {
    List<String> strs = trietree.startWith(prefix);
    int ans = 0;

    for (String s : strs) {
      ans += map.get(s);
    }

    return ans;
  }

  public class TrieNode {
    Map<Character, TrieNode> map = new HashMap<>();
    boolean isEnd = false;
  }

  public class TrieTree {
    TrieNode root;

    public TrieTree() {
      root = new TrieNode();
    }

    public void insert(String s) {
      TrieNode cur = root;
      for (char c : s.toCharArray()) {
        if (!cur.map.containsKey(c)) {
          TrieNode next = new TrieNode();
          cur.map.put(c, next);
        }

        cur = cur.map.get(c);
      }

      cur.isEnd = true;
    }

    public List<String> startWith(String s) {
      List<String> ans = new ArrayList<>();

      TrieNode cur = root;

      for (char c : s.toCharArray()) {
        if (!cur.map.containsKey(c)) {
          return ans;
        }

        cur = cur.map.get(c);
      }

      String path = s;

      while (cur.map.keySet().size() > 0) {
        if (cur.isEnd) {
          ans.add(path);
        }

        for (char c : cur.map.keySet()) {
          String temp = path;
          path = path + c;
          cur = cur.map.get(c);
          path = temp;
        }
      }

      return ans;
    }
  }
}
