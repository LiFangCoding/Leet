package leet._351_400;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

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
        // 找左端点<= x最后一个区间
        // 如果x不在区间里，
        // 1 x -1] x [x + 1 合并
        // 2  x- 1] x
        // 3  x[x + 1
        // 4  [x, x]
        // 时间lowerbound, 是logn, 删除也是log n
        TreeSet<long[]> ts;
        /**
         * Initialize your data structure here.
         */

        private long INF = (long) 1e18;

        public SummaryRanges() {
            ts = new TreeSet<>((x, y) -> Long.compare(x[0], y[0]));
            ts.add(new long[]{-INF, -INF});
            ts.add(new long[]{INF, INF});
        }

        public void addNum(int x) {
            // <= x最后一个元素，> x第一个元素. 最好加两个最小和最大的来处理边界情况. 要== x，也放在左边，所以取最大值。
            long[] r = ts.higher(new long[]{x, Integer.MAX_VALUE});
            long[] l = ts.floor(new long[]{x, Integer.MIN_VALUE});

            if (l[1] >= x) return;
            if (l[1] == x - 1 && r[0] == x + 1) {
                ts.remove(l);
                ts.remove(r);
                ts.add(new long[]{l[0], r[1]});
                // if (x == 2) {
                //     System.out.println("output here");
                //     System.out.println(ts);
                // }
            } else if (l[1] == x - 1) {
                ts.remove(l);
                ts.add(new long[]{l[0], x});
            } else if (r[0] == x + 1) {
                ts.remove(r);
                ts.add(new long[]{x, r[1]});
            } else {
                ts.add(new long[]{x, x});
            }
        }

        public int[][] getIntervals() {
            List<int[]> list = new ArrayList<>();
            for (long[] p : ts) {
                if (p[0] != -INF && p[0] != INF) {
                    list.add(new int[]{(int) p[0], (int) p[1]});
                }
            }
            int[][] res = new int[list.size()][2];
            for (int i = 0; i < list.size(); i++) {
                res[i] = new int[]{list.get(i)[0], list.get(i)[1]};
            }
            return res;
        }
    }

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
}
