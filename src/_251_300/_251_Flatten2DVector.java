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
