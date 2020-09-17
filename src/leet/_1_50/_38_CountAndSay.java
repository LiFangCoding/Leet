package leet._1_50;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * <p>
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: "1"
 * Example 2:
 * <p>
 * Input: 4
 * Output: "1211"
 */
public class _38_CountAndSay {
    public static void main(String[] args) {
        _38_CountAndSay test = new _38_CountAndSay();
        String expected = "111221";

        System.out.println(test.countAndSay(5));
    }

    public String countAndSay(int n) {
        String res = "1";

        for (int i = 2; i <= n; i++) {
            res = getNext(res);
        }

        return res;
    }

    private String getNext(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        int i = 0;

        while (i < chars.length) {
            char target = chars[i];

            int count = 0;
            for (int j = i; j < chars.length && chars[j] == target; j++) {
                count++;
            }

            i = i + count;
            sb.append(count);
            sb.append(target);
        }

        return sb.toString();
    }
}
