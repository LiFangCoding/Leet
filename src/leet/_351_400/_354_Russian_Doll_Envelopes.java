package leet._351_400;

import java.util.Arrays;

/**
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 * <p>
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 * <p>
 * Note:
 * Rotation is not allowed.
 * <p>
 * Example:
 * <p>
 * Input: [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/russian-doll-envelopes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _354_Russian_Doll_Envelopes {
    //TODO: dp
    // f以ai为结尾的上升子序列的集合。属性是最大值
    public int maxEnvelopes(int[][] w) {
        int n = w.length;
        Arrays.sort(w, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });
        int[] f = new int[n];

        int res = 0;
        for (int i = 0; i < n; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (w[j][0] < w[i][0] && w[j][1] < w[i][1]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            res = Math.max(res, f[i]);
        }
        return res;
    }
}
