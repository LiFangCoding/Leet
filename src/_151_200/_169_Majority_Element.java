package _151_200;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class _169_Majority_Element {
    public static void main(String[] args) {
        _169_Majority_Element test = new _169_Majority_Element();
        int[] A = new int[]{3, 2, 3};

        System.out.println(test.majorityElement(A));

        A = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(test.majorityElement(A));
    }

    /**
     * Boyer–Moore majority vote algorithm
     * https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
     */
    public int majorityElement(int[] A) {
        int ans = 0;
        int count = 0;

        for (int num : A) {
            if (count == 0) {
                ans = num;
                count++;
            } else if (ans == num) {
                count++;
            } else {
                count--;
            }
        }

        return ans;
    }

    public int majorityElement_map(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : A) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        int len = A.length;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > len / 2) {
                ans = entry.getKey();
                break;
            }
        }
        return ans;
    }
}
