package leet._251_300;

import java.util.Iterator;

/**
 * Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().
 * <p>
 * Example:
 * <p>
 * Assume that the iterator is initialized to the beginning of the list: [1,2,3].
 * <p>
 * Call next() gets you 1, the first element in the list.
 * Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
 * You call next() the final time and it returns 3, the last element.
 * Calling hasNext() after that should return false.
 * Follow up: How would you extend your design to be generic and work with all types, not just integer?
 */
public class _284_Peeking_Iterator {
    class PeekingIterator implements Iterator<Integer> {
        int cur;
        boolean hasNext;
        Iterator<Integer> iterator;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            hasNext = iterator.hasNext();
            if (hasNext) {
                cur = iterator.next();
            }
            this.iterator = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return cur;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            int t = cur;
            hasNext = iterator.hasNext();
            if (hasNext) {
                cur = iterator.next();
            }
            return t;
        }

        @Override
        public boolean hasNext() {
            return hasNext;
        }
    }
}
