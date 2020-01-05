package _101_150;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * <p>
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * <p>
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 * <p>
 * Note:
 * <p>
 * If there exists a solution, it is guaranteed to be unique.
 * Both input arrays are non-empty and have the same length.
 * Each element in the input arrays is a non-negative integer.
 * Example 1:
 * <p>
 * Input:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * <p>
 * Output: 3
 * <p>
 * Explanation:
 * Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 4. Your tank = 4 - 1 + 5 = 8
 * Travel to station 0. Your tank = 8 - 2 + 1 = 7
 * Travel to station 1. Your tank = 7 - 3 + 2 = 6
 * Travel to station 2. Your tank = 6 - 4 + 3 = 5
 * Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
 * Therefore, return 3 as the starting index.
 * Example 2:
 * <p>
 * Input:
 * gas  = [2,3,4]
 * cost = [3,4,3]
 * <p>
 * Output: -1
 * <p>
 * Explanation:
 * You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
 * Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 0. Your tank = 4 - 3 + 2 = 3
 * Travel to station 1. Your tank = 3 - 3 + 3 = 3
 * You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
 * Therefore, you can't travel around the circuit once no matter where you start.
 */
public class _134_Gas_Station {
    /**
     * O(n)
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0) {
            return 0;
        }

        int len = gas.length;

        int total = 0;
        for (int i = 0; i < len; i++) {
            total += gas[i] - cost[i];
        }

        if (total < 0) {
            return -1;
        }

        int res = 0;
        int count = 0;
        for (int i = 0; i < len; i++) {
            count += gas[i] - cost[i];

            if (count < 0) {
                count = 0;
                res = i + 1;
            }
        }

        return res;
    }

    /**
     * O(n ^ 2)
     *
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit_brute(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0) {
            return 0;
        }

        int len = gas.length;

        for (int i = 0; i < len; i++) {
            int count = 0;
            for (int k = 0; k < len; k++) {
                count += gas[(i + k) % len] - cost[(i + k) % len];
                if (count < 0) {
                    break;
                }
            }
            if (count >= 0) {
                return i;
            }
        }

        return -1;
    }
}
