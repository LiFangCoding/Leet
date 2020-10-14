package leet._351_400;

public class _396_Rotate_Function {
    public int maxRotateFunction(int[] A) {
        long sum = 0, cur = 0;
        for (int x : A)
            sum += x;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            cur += i * A[i];
        }
        long res = cur;
        for (int i = n - 1; i >= 0; i--) {
            cur += sum - n * A[i];
            res = Math.max(res, cur);
        }
        return (int) res;
    }
}
