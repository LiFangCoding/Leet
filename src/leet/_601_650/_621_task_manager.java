package leet._601_650;

import java.util.Arrays;

/**
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 * <p>
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.
 * <p>
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 * <p>
 *  
 * <p>
 * Example:
 * <p>
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 *  
 * <p>
 * Constraints:
 * <p>
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/task-scheduler
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _621_task_manager {
    //作者：popopop
    // https://leetcode-cn.com/problems/task-scheduler/solution/tong-zi-by-popopop/
    //作者：popopop
    // https://leetcode-cn.com/problems/task-scheduler/solution/tong-zi-by-popopop/
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;

        int[] map = new int[26];
        for (char c : tasks) {
            ++map[c - 'A'];
        }

        // be careful cannot use the lambda for int[] array
        Arrays.sort(map);

        int maxNum = map[map.length - 1];
        int cnt = 0;

        int idx = map.length - 1;
        // because map is from large to small, so it is ok to scan from left to right
        while (idx >= 0 && map[idx--] == maxNum) {
            cnt++;
        }

        return Math.max(len, cnt + (n + 1) * (maxNum - 1));
    }
}
