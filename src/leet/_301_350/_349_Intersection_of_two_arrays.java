package leet._301_350;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 * <p>
 * Each element in the result must be unique.
 * The result can be in any order.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _349_Intersection_of_two_arrays {
    class Sol_set {
        public int[] intersection(int[] A1, int[] A2) {
            List<Integer> anslist = new ArrayList<>();

            Set<Integer> set = new HashSet<>();

            for (int num : A1) {
                set.add(num);
            }

            for (int num : A2) {
                if (set.contains(num)) {
                    anslist.add(num);
                    set.remove(num);
                }
            }

            int[] ans = new int[anslist.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = anslist.get(i);
            }

            return ans;
        }
    }
}
