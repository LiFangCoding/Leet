package leet;

public class _1437_Check_If_All1areAtLeastLenK {
    public boolean kLengthApart(int[] A, int k) {
        Integer firstIdx = null;

        for (int i = 0; i < A.length; i++) {
            if (A[i] == 1) {
                if (firstIdx == null) {
                    firstIdx = i;
                    continue;
                }

                int secondIdx = i;
                if (secondIdx - firstIdx - 1 < k) {
                    return false;
                } else {
                    firstIdx = secondIdx;
                }
            }
        }

        return true;
    }
}
