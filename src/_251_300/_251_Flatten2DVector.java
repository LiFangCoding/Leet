package _251_300;

/**
 * Design and implement an iterator to flatten a 2d vector. It should support the following operations: next and hasNext.
 * <p>
 *  
 * <p>
 * Example:
 * <p>
 * Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
 * <p>
 * iterator.next(); // return 1
 * iterator.next(); // return 2
 * iterator.next(); // return 3
 * iterator.hasNext(); // return true
 * iterator.hasNext(); // return true
 * iterator.next(); // return 4
 * iterator.hasNext(); // return false
 *  
 * <p>
 * Notes:
 * <p>
 * Please remember to RESET your class variables declared in Vector2D, as static/class variables are persisted across multiple test cases. Please see here for more details.
 * You may assume that next() call will always be valid, that is, there will be at least a next element in the 2d vector when next() is called.
 *  
 * <p>
 * Follow up:
 * <p>
 * As an added challenge, try to code it using only iterators in C++ or iterators in Java.
 */
public class _251_Flatten2DVector {


    // 作者：LeetCode
// 链接：https://leetcode-cn.com/problems/flatten-2d-vector/solution/zhan-kai-er-wei-xiang-liang-by-leetcode/
// 来源：力扣（LeetCode）
// 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    class Sol_shorter {
        class Vector2D {

            private int[][] vector;
            private int inner = 0;
            private int outer = 0;

            public Vector2D(int[][] v) {
                // We need to store a *reference* to the input vector.
                vector = v;
            }

            // If the current outer and inner point to an integer, this method does nothing.
            // Otherwise, inner and outer are advanced until they point to an integer.
            // If there are no more integers, then outer will be equal to vector.length
            // when this method terminates.
            private void advanceToNext() {
                // While outer is still within the vector, but inner is over the
                // end of the inner list pointed to by outer, we want to move
                // forward to the start of the next inner vector.
                while (outer < vector.length && inner == vector[outer].length) {
                    inner = 0;
                    outer++;
                }
            }

            public int next() {
                // As per Java specs, throw an exception if there's no next.
                // This will also ensure the pointers point to an integer otherwise.
                // Return current element and move inner so that is after the current
                // element.
                if (!hasNext()) {
                    return -1;
                }
                // System.out.println("val is " + vector[outer][inner]);
                return vector[outer][inner++];
            }

            public boolean hasNext() {
                // Ensure the position pointers are moved such they point to an integer,
                // or put outer = vector.length.
                advanceToNext();
                // If outer = vector.length then there are no integers left, otherwise
                // we've stopped at an integer and so there's an integer left.
                return outer < vector.length;
            }
        }
    }

    class Vector2D {
        /**
         * [[1,2,3], [4,5], [6], [7,8,9]
         *
         * @param v
         */

        int start;
        int cur;
        int[][] v;

        public Vector2D(int[][] v) {
            this.v = v;
            this.cur = 0;
            this.start = 0;
        }

        public int next() {
            while (v[start] == null || v[start].length == 0) {
                start++;
            }

            if (cur < v[start].length) {
                int res = v[start][cur];
                cur++;
                return res;
            } else {
                start++;
                while (v[start] == null || v[start].length == 0) {
                    start++;
                }
                cur = 0;
                return v[start][cur];
            }
        }

        public boolean hasNext() {
            return start != (v.length - 1) || cur != v[start].length;
        }
    }
}
