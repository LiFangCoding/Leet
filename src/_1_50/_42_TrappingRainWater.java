package _1_50;

import java.util.Stack;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * <p>
 * <p>
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class _42_TrappingRainWater {


    /**
     * O(N)
     * 找到数组中从下标 i 到最左端最高的条形块高度 \text{left\_max}left_max。
     * 找到数组中从下标 i 到最右端最高的条形块高度 \text{right\_max}right_max。
     * 扫描数组 \text{height}height 并更新答案：
     * 累加 \min(\text{max\_left}[i],\text{max\_right}[i]) - \text{height}[i]min(max_left[i],max_right[i])−height[i] 到 ansans 上
     * C++
     */
    public int trap_DP(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        int len = A.length;
        int ans = 0;

        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];

        maxLeft[0] = A[0];
        for (int i = 1; i < len; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], A[i]);
        }

        maxRight[len - 1] = A[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], A[i]);
        }


        for (int i = 0; i < len; i++) {
            ans += Math.min(maxLeft[i], maxRight[i]) - A[i];
        }

        return ans;
    }

    /**
     * https://leetcode-cn.com/problems/trapping-rain-water/solution/trapping-rain-water-by-ikaruga/
     * O(n) time
     */
    public int trap_monoStack(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        // stack put the index as mono stack. Because we need to know the idx1- idx2 as len.
        // If decreasing, add into stack, cause cannot get water.
        Stack<Integer> idxStk = new Stack<>();
        int len = A.length;
        int ans = 0;

        for (int i = 0; i < len; i++) {
            if (idxStk.isEmpty() || A[i] <= A[idxStk.peek()]) {
                idxStk.push(i);
            } else {
                while (!idxStk.isEmpty() && A[i] > A[idxStk.peek()]) {
                    // also need to compare with left and right to see
                    int cur = idxStk.pop();
                    if (idxStk.isEmpty()) {
                        break;
                    }

                    int l = idxStk.peek();
                    int r = i;
                    int h = Math.min(A[l], A[r]) - A[cur];
                    ans += (r - l - 1) * h;

                }

                // after that also need add into stack
                idxStk.add(i);
            }
        }

        return ans;
    }
}
