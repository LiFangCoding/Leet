package _151_200;

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

    public int majorityElement(int[] A) {
        int count = 1;
        int cur = A[0];

        for (int i = 1; i < A.length; i++) {
            if (cur == A[i]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    cur = A[i];
                    count = 1;
                }
            }
        }

        return cur;
    }
}
