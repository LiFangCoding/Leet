package leet._301_350;

import java.util.*;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 * <p>
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 * <p>
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */
public class _350_Intersection_of_Two_Arrays2 {
    class Sol_map_n {
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int x : nums1) {
                map.put(x, map.getOrDefault(x, 0) + 1);
            }

            List<Integer> list = new ArrayList<>();
            for (int x : nums2) {
                if (map.containsKey(x) && map.get(x) > 0) {
                    list.add(x);
                    map.put(x, map.get(x) - 1);
                }
            }
            int[] res = new int[list.size()];
            for (int i = 0; i < res.length; i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }

    class Sol_two_pointers_nlogn {
        public int[] intersect_two_pointers(int[] A1, int[] A2) {
            if (A1 == null || A2 == null) {
                return new int[0];
            }

            Arrays.sort(A1);
            Arrays.sort(A2);

            int idx1 = 0;
            int len1 = A1.length;
            int idx2 = 0;
            int len2 = A2.length;

            List<Integer> list = new ArrayList<>();
            while (idx1 < len1 && idx2 < len2) {
                if (A1[idx1] == A2[idx2]) {
                    list.add(A1[idx1]);
                    idx1++;
                    idx2++;
                } else if (A1[idx1] < A2[idx2]) {
                    idx1++;
                } else {
                    idx2++;
                }
            }

            int[] ans = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                ans[i] = list.get(i);
            }
            return ans;
        }
    }
}
