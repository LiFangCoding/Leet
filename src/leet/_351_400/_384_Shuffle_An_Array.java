package leet._351_400;

import java.util.Random;

public class _384_Shuffle_An_Array {
    class Solution {
        int[] a;
        int[] ori;
        Random rand = new Random();

        public Solution(int[] nums) {
            a = nums;
            int n = nums.length;
            ori = new int[n];
            for (int i = 0; i < n; i++) {
                ori[i] = nums[i];
            }
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            int n = a.length;
            for (int i = 0; i < n; i++) {
                a[i] = ori[i];
            }
            return a;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            int n = a.length;
            for (int i = 0; i < n; i++) {
                int idx = rand.nextInt(i + 1);
                int t = a[i];
                a[i] = a[idx];
                a[idx] = t;
            }
            return a;
        }
    }
}
