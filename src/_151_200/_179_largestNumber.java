package _151_200;

import java.util.Arrays;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * <p>
 * Example 1:
 * <p>
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 * <p>
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 */
public class _179_largestNumber {
    public static void main(String[] args) {
        _179_largestNumber test = new _179_largestNumber();
        int[] A = new int[]{3, 30, 34, 5, 9};
        System.out.println(test.largestNumber(A));

        A = new int[]{824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247};
        System.out.println(test.largestNumber(A));
    }

    public String largestNumber(int[] A) {
        if (A == null || A.length == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        String[] strs = new String[A.length];
        for (int i = 0; i < A.length; i++) {
            strs[i] = String.valueOf(A[i]);
        }

        Arrays.sort(strs, (s1, s2) ->
                {
                    return (s1 + s2).compareTo(s2 + s1);
                }

        );

        for (int i = A.length - 1; i >= 0; i--) {
            sb.append(strs[i]);
        }

        /**
         * !!! Consider special cases
         * [0, 0]
         */
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}
