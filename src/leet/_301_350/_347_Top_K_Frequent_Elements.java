package leet._301_350;

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * <p>
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 * <p>
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class _347_Top_K_Frequent_Elements {

    class Sol_n {
        // 计数排序的思想
        // O(n)
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int x : nums) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }
            int n = nums.length;
            // 记录每种次数元素个数
            int[] s = new int[n + 1];
            for (int x : map.keySet()) {
                s[map.get(x)]++;
            }
            int i = n, t = 0;
            while (t < k) {
                t += s[i--];
            }

            int[] res = new int[k];
            int idx = 0;
            for (int x : map.keySet()) {
                if (map.get(x) > i) {
                    res[idx++] = x;
                }
            }
            return res;
        }
    }

    class Sol_nlogk {
        public List<Integer> topKFrequent(int[] A, int k) {
            // key -> value
            // num -> count
            Map<Integer, Integer> map = new HashMap<>();

            for (int num : A) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            PriorityQueue<Integer> minq = new PriorityQueue<>(k, (key1, key2) -> Integer.compare(map.get(key1), map.get(key2)));

            for (int key : map.keySet()) {
                minq.add(key);
                if (minq.size() > k) {
                    minq.remove();
                }
            }

            List<Integer> ans = new ArrayList<>();
            minq.forEach(i -> ans.add(i));
            Collections.reverse(ans);
            return ans;
        }
    }
}
