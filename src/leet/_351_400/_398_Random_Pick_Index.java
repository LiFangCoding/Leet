package leet._351_400;

import java.util.*;

public class _398_Random_Pick_Index {
    class Solution {
        Map<Integer, List<Integer>> map;
        Random rand;

        public Solution(int[] nums) {
            rand = new Random();
            map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int x = nums[i];
                if (!map.containsKey(x)) {
                    map.put(x, new ArrayList<>());
                }
                map.get(x).add(i);
            }
        }

        public int pick(int target) {
            List<Integer> list = map.get(target);
            int idx = rand.nextInt(list.size());
            return list.get(idx);
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
}
