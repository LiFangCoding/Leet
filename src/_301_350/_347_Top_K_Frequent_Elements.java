package _301_350;

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
    public static void main(String[] args) {
        _347_Top_K_Frequent_Elements test = new _347_Top_K_Frequent_Elements();
        int[] A = new int[]{1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(test.topKFrequent(A, k));
    }

    public List<Integer> topKFrequent_bucket_sort(int[] A, int k) {
        // key -> value
        // num -> count
        Map<Integer, Integer> map = new HashMap<>();
        int maxCnt = 0;

        for (int num : A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            maxCnt = Math.max(maxCnt, map.get(num));
        }

        List<List<Integer>> buckets = new ArrayList<>(maxCnt + 1);
        for (int i = 0; i <= maxCnt; i++) {
            buckets.add(new ArrayList<>());
        }

        map.forEach((key, val) ->
                buckets.get(val).add(key));

        List<Integer> ans = new ArrayList<>();
        for (int i = maxCnt; i >= 0 && ans.size() < k; --i) {
            for (int num : buckets.get(i)) {
                ans.add(num);
            }
            if (ans.size() == k) {
                break;
            }
        }

        return ans;
    }

    public List<Integer> topKFrequent(int[] A, int k) {
        // key -> value
        // num -> count
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                k, (key1, key2) -> Integer.compare(map.get(key1), map.get(key2)));

        for (int key : map.keySet()) {
            pq.add(key);
            if (pq.size() > k) {
                pq.remove();
            }
        }

        List<Integer> ans = new ArrayList<>();
        pq.forEach(i -> ans.add(i));
        Collections.reverse(ans);
        return ans;
    }
}
