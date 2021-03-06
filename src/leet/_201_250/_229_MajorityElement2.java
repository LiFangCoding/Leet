package leet._201_250;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * <p>
 * Note: The algorithm should run in linear time and in O(1) space.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: [3]
 * Example 2:
 * <p>
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 */
public class _229_MajorityElement2 {

    class Sol_acwing {
        public List<Integer> majorityElement(int[] nums) {
            int r1 = 0, r2 = 0, c1 = 0, c2 = 0;

            for (int x : nums) {
                if (c1 != 0 && x == r1) {
                    c1++;
                } else if (c2 != 0 && x == r2) {
                    c2++;
                } else if (c1 == 0) {
                    r1 = x;
                    c1++;
                } else if (c2 == 0) {
                    r2 = x;
                    c2++;
                } else {
                    c1--;
                    c2--;
                }
            }

            c1 = 0;
            c2 = 0;
            for (int x : nums) {
                if (x == r1) {
                    c1++;
                } else if (x == r2) {
                    c2++;
                }
            }

            int n = nums.length;
            List<Integer> res = new ArrayList<>();
            if (c1 > n / 3)
                res.add(r1);
            if (c2 > n / 3)
                res.add(r2);
            return res;
        }
    }

    public static void main(String[] args) {
        _229_MajorityElement2 test = new _229_MajorityElement2();
        int[] A = new int[] { 3, 2, 3 };
        System.out.println(test.majorityElement(A));

        A = new int[] { 1, 1, 1, 3, 3, 2, 2, 2 };
        System.out.println(test.majorityElement(A));
    }

    public List<Integer> majorityElement(int[] A) {
        List<Integer> res = new ArrayList<>();

        if (A == null || A.length == 0) {
            return res;
        }

        /**
         * 1,3,1,3,5
         *
         * 1,5,3,3,1
         *
         * !!! be careful if A[0] == A[1]
         */
        int count1 = 0;
        int count2 = 0;
        int first = 0;
        int second = 0;

        /**
         * !!! start from i = 0.
         * Set first, second default value. Because count1 == 0, count2 == 0,
         * if not same, it will be assigned different value.
         *
         * Be careful just 1 if.
         *
         * Cannot change the order of count1, coun2 before A[i] == .
         * [8,8,7,7,7]
         *输出
         * [7]
         * 预期结果
         * [8,7]
         */
        for (int i = 0; i < A.length; i++) {
            if (A[i] == first) {
                count1++;
            } else if (A[i] == second) {
                count2++;
            } else if (count1 == 0) {
                first = A[i];
                count1++;
            } else if (count2 == 0) {
                second = A[i];
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        /**
         * Need else, because it can be same value first == second.
         */
        for (int i = 0; i < A.length; i++) {
            if (A[i] == first) {
                count1++;
            } else if (A[i] == second) {
                count2++;
            }
        }

        if (count1 > A.length / 3) {
            res.add(first);
        }

        if (count2 > A.length / 3) {
            res.add(second);
        }

        return res;
    }
}
