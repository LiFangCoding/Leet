package leet._51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * <p>
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code.
 * A gray code sequence must begin with 0.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: [0,1,3,2]
 * Explanation:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * <p>
 * For a given n, a gray code sequence may not be uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence.
 * <p>
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * Example 2:
 * <p>
 * Input: 0
 * Output: [0]
 * Explanation: We define the gray code sequence to begin with 0.
 * A gray code sequence of n has size = 2n, which for n = 0 the size is 20 = 1.
 * Therefore, for n = 0 the gray code sequence is [0].
 */
public class _89_Gray_Code {
    //TODO
    /**
     * 先构造 n=1，即只有一位的格雷码序列：[0, 1]；
     * 假设我们已经构造好了 n=kn=k时的格雷码序列 SkSk，我们可以利用它来构造 Sk+1Sk+1：
     * (1) Sk+1Sk+1的前一半：将 SkSk 中的每个数开头补上1；
     * (2) Sk+1Sk+1的后一半，将 SkSk 变成逆序，然后在每个数开头补上0；
     * 时间复杂度分析：对于给定的 nn，计算量是 2(1+2+4+…+2n−1)=2n+1−22(1+2+4+…+2n−1)=2n+1−2，所以时间复杂度是 O(2n)O(2n)。
     */
    /**
     * 作者：jyd
     * 链接：https://leetcode-cn.com/problems/gray-code/solution/gray-code-jing-xiang-fan-she-fa-by-jyd/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);

        int head = 1;

        for (int i = 0; i < n; i++) {
            for (int j = ans.size() - 1; j >= 0; j--) {
                ans.add(head + ans.get(j));
            }
            head <<= 1;
        }
        return ans;
    }
}