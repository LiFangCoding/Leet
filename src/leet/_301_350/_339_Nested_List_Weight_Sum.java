package leet._301_350;

import java.util.List;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1],2,[1,1]]
 * Output: 10
 * Explanation: Four 1's at depth 2, one 2 at depth 1.
 * Example 2:
 * <p>
 * Input: [1,[4,[6]]]
 * Output: 27
 * Explanation: One 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/nested-list-weight-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _339_Nested_List_Weight_Sum {

    /**
     * https://www.acwing.com/solution/content/11461/
     *
     * @param nestedList
     * @return
     */
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> nestedList, int d) {
        int ans = 0;
        for (NestedInteger nt : nestedList) {
            if (nt.isInteger()) {
                ans += nt.getInteger() * d;
            } else {
                ans += helper(nt.getList(), d + 1);
            }
        }
        return ans;
    }

    public interface NestedInteger {
        //        // Constructor initializes an empty nested list.
        //        public NestedInteger();
        //
        //        // Constructor initializes a single integer.
        //        public NestedInteger(int value);

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
