package leet._401_450;

public class _413_Arithmetic_Slices {
    // 差分数组里连续的一段
    // 长度有多少>=3的区间
    public int numberOfArithmeticSlices(int[] A) {
        for (int i = A.length - 1; i > 0; i--) {
            A[i] -= A[i - 1];
        }
        int res = 0;
        for (int i = 1; i < A.length; i++) {
            int j = i;
            while (j < A.length && A[j] == A[i]) j++;
            int k = j - i;
            res += k * (k - 1) / 2;
            i = j - 1;
        }
        return res;
    }
}
