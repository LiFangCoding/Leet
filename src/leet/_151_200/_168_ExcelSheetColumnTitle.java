package leet._151_200;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * <p>
 * For example:
 * <p>
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * ...
 * Example 1:
 * <p>
 * Input: 1
 * Output: "A"
 * Example 2:
 * <p>
 * Input: 28
 * Output: "AB"
 * Example 3:
 * <p>
 * Input: 701
 * Output: "ZY"
 */
public class _168_ExcelSheetColumnTitle {
    public static void main(String[] args) {
        _168_ExcelSheetColumnTitle test = new _168_ExcelSheetColumnTitle();
        //        System.out.println(test.convertToTitle(1));
        //        System.out.println(test.convertToTitle(28));
        System.out.println(test.convertToTitle(701));

        System.out.println(701 % 26);
    }

    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            /**
             * Everytime, delete 1 from n for the last digit condition
             */
            n--;
            int reminder = (n - 1) % 26;
            n /= 26;
            /**
             * !!! remember to / by 26
             *
             * coner case 26.
             */
            char c = (char) (reminder + 'A');
            sb.append(c);
        }

        return sb.reverse().toString();
    }
}
