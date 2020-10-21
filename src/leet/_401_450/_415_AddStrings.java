package leet._401_450;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _415_AddStrings {

    /**
     * 2ms
     * T = n
     * S = n
     *
     * @return
     */
    List<Integer> add(int[] A, int[] B) {
        List<Integer> C = new ArrayList<>();
        for (int i = 0, t = 0; i < A.length || i < B.length || t != 0; i++) {
            if (i < A.length) {
                t += A[i];
            }

            if (i < B.length) {
                t += B[i];
            }
            C.add(t % 10);
            t /= 10;
        }

        return C;
    }

    public String addStrings(String a, String b) {
        // 从个位，十位开始算
        int[] A = new int[a.length()];
        int[] B = new int[b.length()];
        for (int i = a.length() - 1, idx = 0; i >= 0; i--) {
            A[idx++] = a.charAt(i) - '0';
        }

        for (int i = b.length() - 1, idx = 0; i >= 0; i--) {
            B[idx++] = b.charAt(i) - '0';
        }

        List<Integer> C = add(A, B);
        StringBuilder sb = new StringBuilder();
        // revese back
        for (int i = C.size() - 1; i >= 0; i--) {
            sb.append(C.get(i));
        }
        return sb.toString();
    }
}
