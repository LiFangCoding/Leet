package _51_100;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * <p>
 * <p>
 * <p>
 * <p>
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * <p>
 * <p>
 * <p>
 * <p>
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: [2,1,5,6,2,3]
 * Output: 10
 */
public class _84_LargestRectangleinHistogram {
    //TODO: understand

    /**
     * 考点：
     * <p>
     * 单调栈
     * 题解：
     * 用九章算法强化班中讲过的单调栈(stack)。维护一个单调递增栈，逐个将元素 push 到栈里。push 进去之前先把 >= 自己的元素 pop 出来。
     * 每次从栈中 pop 出一个数的时候，就找到了往左数比它小的第一个数（当前栈顶）和往右数比它小的第一个数（即将入栈的数），
     * 从而可以计算出这两个数中间的部分宽度 * 被pop出的数，就是以这个被pop出来的数为最低的那个直方向两边展开的最大矩阵面积。
     * 因为要计算两个数中间的宽度，因此放在 stack 里的是每个数的下标。
     *
     * @param height
     * @return
     */
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();  //维护单调递增
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int curt = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && curt <= height[stack.peek()]) {    //如果栈顶高度大于当前高度
                int h = height[stack.pop()];        //保存栈顶元素信息
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;        //如果栈已经为空，宽度为i，否则i-s.top()-1
                max = Math.max(max, h * w);
            }
            stack.push(i);                //压入栈中
        }

        return max;
    }
}
