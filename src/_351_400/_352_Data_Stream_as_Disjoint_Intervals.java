package _351_400;

/**
 * Given a data stream input of non-negative integers a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.
 * <p>
 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ..., then the summary will be:
 * <p>
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 * <p>
 * Follow up:
 * <p>
 * What if there are lots of merges and the number of disjoint intervals are small compared to the data stream's size?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _352_Data_Stream_as_Disjoint_Intervals {
    //TODO: https://www.acwing.com/solution/content/373/

    /**
     * (平衡树) addNum: O(logn)O(logn), getIntervals: O(n)O(n)
     * 我们用 map<int,int> L, R 来动态维护所有区间，L可以从区间右端点索引到左端点，R可以从区间左端点索引到右端点。
     * 举例来说，假设有个区间是[x, y]，则L[y] = x并且R[x] = y。
     * <p>
     * 对于addNum(val)操作：
     * <p>
     * 我们先判断val是否已经包含在某个区间中。具体来说，先用upper_bound(val)找出最后一个左端点小于等于val的区间，然后判断该区间的右端点是否大于等于val。
     * 如果val不包含在任何区间中，则分别判断val-1和val+1是否存在：
     * 如果都存在，则合并左右区间，合并方式：R[L[val - 1]] = R[val + 1]，L[R[val + 1]] = L[val - 1]，然后将R[val+1]和L[val-1]删除；
     * 如果只有一边存在，则将val插入该区间中；
     * 如果都不存在，则将val表示成一个单独的区间；
     * 对于getIntervals()操作，直接输出所有区间即可。
     * <p>
     * 时间复杂度分析：对于addNum操作，只涉及常数次平衡树的增删改查操作，所以时间复杂度是 O(logn)O(logn)。对于getIntervals操作，需要将整棵平衡树遍历一遍，所以时间复杂度是 O(n)O(n)。
     * <p>
     * 作者：yxc
     * 链接：https://www.acwing.com/solution/content/373/
     * 来源：AcWing
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    class SummaryRanges {

        //        /** Initialize your data structure here. */
        //        public SummaryRanges() {
        //
        //        }
        //
        //        public void addNum(int val) {
        //
        //        }
        //
        //        public int[][] getIntervals() {
        //
        //        }
    }
}
