package leet;

import java.util.Arrays;

/**
 * You have an array of logs.  Each log is a space delimited string of words.
 * <p>
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 * <p>
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
 * <p>
 * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.
 * <p>
 * Return the final order of the logs.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 *  
 * <p>
 * Constraints:
 * <p>
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] is guaranteed to have an identifier, and a word after the identifier.
 */
public class _937_Reorder_Data_in_Log_Files {
    public String[] reorderLogFiles(String[] logs) {
        // Arrays sort object[] is stable. For primitive[] sort in java is quicksort, which is not stable
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);

            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                // we can sort string. char[] is to sort chars in array
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            }

            //如果isDigit1是真，也就是说log1数字类型的，判断括号内容，isDigit2也是真，也就是log2也是数字，那么返回0，两者一样大，如果lsDigit2是假，不是数字，返回1，那么log1比log2大，首先应清楚两者在这里不可能同时为字母日志，上面已经判断过了，如果isDigit为假，则表示字母日志，那样isDigit2必为假，此时返回-1，也就是log1比log2小。
            if (isDigit1 && isDigit2) {
                return 0;
            } else if (isDigit1) {
                return 1;
            } else {
                return -1;
            }
        });

        return logs;
    }
}
