package _101_150;

/**
 * Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.
 * <p>
 * Note:
 * <p>
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Example 1:
 * <p>
 * Input: [2,2,3,2]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [0,1,0,1,0,1,99]
 * Output: 99
 */
public class _137_Single_Number2 {
    public static void main(String[] args) {
        _137_Single_Number2 test = new _137_Single_Number2();
        System.out.println(test.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));

        System.out.println(1 ^ 1);
        System.out.println(1 ^ 0);
        System.out.println(0 ^ 1);
        System.out.println(0 ^ 0);

        System.out.println("|");
        System.out.println(1 | 1);
        System.out.println(1 | 0);
        System.out.println(0 | 1);
        System.out.println(0 | 0);
    }

    public int singleNumber(int[] A) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int res = 0;

        for (int bit = 0; bit < 32; bit++) {
            int count = 0;
            for (int num : A) {
                count += (num >> bit) & 1;
            }
            count %= 3;
            res += count << bit;
        }
        return res;
    }
}
