package _351_400;

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
public class _372_Find_K_Pairs_with_Smallest_Sums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return ans;

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> Integer.compare(nums1[a.x] + nums2[a.y], nums1[b.x] + nums2[b.y]));
        for (int i = 0; i < nums1.length; i++) {
            pq.add(new Node(i, 0));
        }

        while (!pq.isEmpty() && ans.size() < k) {
            Node t = pq.remove();
            List<Integer> list = new ArrayList<>();
            list.add(nums1[t.x]);
            list.add(nums2[t.y]);
            ans.add(list);
            if (t.y + 1 < nums2.length) {
                pq.add(new Node(t.x, t.y + 1));
            }
        }

        return ans;
    }

    class Node {
        int x, y;

        public Node(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }
}
