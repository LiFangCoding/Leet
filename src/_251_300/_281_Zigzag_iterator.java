package _251_300;

import java.util.List;

/**
 * Given two 1d vectors, implement an iterator to return their elements alternately.
 * <p>
 *  
 * <p>
 * Example:
 * <p>
 * Input:
 * v1 = [1,2]
 * v2 = [3,4,5,6]
 * Output: [1,3,2,4,5,6]
 * Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,3,2,4,5,6].
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-iterator
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _281_Zigzag_iterator {
    /**
     * 1ms
     * T = m + n
     * https://www.jiuzhang.com/solution/zigzag-iterator/#tag-other-lang-java
     */
    class Sol_two_pointers {
        class ZigzagIterator {
            int indexV1 = 0;
            int indexV2 = 0;
            int lenV1 = 0;
            int lenV2 = 0;
            List<Integer> v1;
            List<Integer> v2;

            /*
             * @param v1: A 1d vector
             * @param v2: A 1d vector
             */
            public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
                lenV1 = v1.size();
                lenV2 = v2.size();
                this.v1 = v1;
                this.v2 = v2;
            }

            /*
             * @return: An integer
             */
            public int next() {
                if (indexV1 < lenV1 && indexV2 < lenV2) {
                    // write your code here
                    if (indexV1 == indexV2) {
                        return v1.get(indexV1++);
                    } else {
                        return v2.get(indexV2++);
                    }
                } else if (indexV1 >= lenV1) {
                    return v2.get(indexV2++);
                } else {
                    return v1.get(indexV1++);
                }

            }

            /*
             * @return: True if has next
             */
            public boolean hasNext() {
                // write your code here
                return indexV1 < lenV1 || indexV2 < lenV2;
            }
        }
    }

}
