package leet;

/**
 * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
 * <p>
 * Given row N and index K, return the K-th indexed symbol in row N. (The values of K are 1-indexed.) (1 indexed).
 * <p>
 * Examples:
 * Input: N = 1, K = 1
 * Output: 0
 * <p>
 * Input: N = 2, K = 1
 * Output: 0
 * <p>
 * Input: N = 2, K = 2
 * Output: 1
 * <p>
 * Input: N = 4, K = 5
 * Output: 1
 * <p>
 * Explanation:
 * row 1: 0
 * row 2: 01
 * row 3: 0110
 * row 4: 01101001
 * Note:
 * <p>
 * N will be an integer in the range [1, 30].
 * K will be an integer in the range [1, 2^(N-1)].
 */
public class _779_Kth_Symbol_In_Grammar {
    public int kthGrammar(int N, int K) {
        if (N == 1) {
            if (K == 1) {
                return 0;
            }
        }

        int prevRank = (K + 1) / 2;
        boolean first = (K % 2 == 1);

        int val = kthGrammar(N - 1, prevRank);
        if (val == 0) {
            return first ? 0 : 1;
        } else {
            return first ? 1 : 0;
        }
    }
}
