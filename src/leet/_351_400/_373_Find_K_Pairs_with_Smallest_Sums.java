package leet._351_400;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.
 * <p>
 * Define a pair (u,v) which consists of one element from the first array and one element from the second array.
 * <p>
 * Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * Output: [[1,2],[1,4],[1,6]]
 * Explanation: The first 3 pairs are returned from the sequence:
 *              [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * Example 2:
 * <p>
 * Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * Output: [1,1],[1,1]
 * Explanation: The first 2 pairs are returned from the sequence:
 *              [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * Example 3:
 * <p>
 * Input: nums1 = [1,2], nums2 = [3], k = 3
 * Output: [1,3],[2,3]
 * Explanation: All possible pairs are returned from the sequence: [1,3],[2,3]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _373_Find_K_Pairs_with_Smallest_Sums {
    // 多路归并。 从B0A0,.... B0An-1.
    //            Bm-1A0 ... Bm-1An-1
    public List<List<Integer>> kSmallestPairs(int[] a, int[] b, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (a == null || b == null || a.length == 0 || b.length == 0) {
            return res;
        }
        int n = a.length, m = b.length;
        PriorityQueue<int[]> minPq = new PriorityQueue<>((x, y) -> Integer.compare(x[0], y[0]));

        for (int i = 0; i < m; i++) {
            // sum, a idx, b idx
            minPq.add(new int[]{b[i] + a[0], 0, i});
        }

        while (k-- > 0 && !minPq.isEmpty()) {
            int[] t = minPq.remove();
            int tai = t[1], tbi = t[2];
            List<Integer> list = new ArrayList<>();
            list.add(a[tai]);
            list.add(b[tbi]);
            res.add(list);
            if (tai + 1 < n) {
                minPq.add(new int[]{b[tbi] + a[tai + 1], tai + 1, tbi});
            }
        }
        return res;
    }
}
