package leet._151_200;

import java.util.HashMap;
import java.util.Map;

/**
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 * <p>
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 * <p>
 * Example 1:
 * <p>
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 * Example 2:
 * <p>
 * add(3); add(1); add(2);
 * find(3) -> true
 * find(6) -> false
 */
public class _170_TwoSum3_Data_structure_design {
    /**
     * value -> its count
     */
    Map<Integer, Integer> map;

    public _170_TwoSum3_Data_structure_design() {
        map = new HashMap<>();
    }

    /**
     * Add the number to an internal data structure..
     */
    public void add(int num) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    /**
     * Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        for (int num : map.keySet()) {
            int anotherNum = value - num;

            if (anotherNum == num) {
                if (map.get(anotherNum) >= 2) {
                    return true;
                }
            } else {
                if (map.containsKey(anotherNum)) {
                    return true;
                }
            }
        }
        return false;
    }
}
