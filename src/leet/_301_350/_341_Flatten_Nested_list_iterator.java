package leet._301_350;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Given a nested list of integers,implement an iterator to flatten it.
 * <p>
 * Each element is either an integer,or a list--whose elements may also be integers or other lists.
 * <p>
 * Example 1:
 * <p>
 * Input:[[1,1],2,[1,1]]
 * Output:[1,1,2,1,1]
 * Explanation:By calling next repeatedly until hasNext returns false,
 *              the order of elements returned by next should be:[1,1,2,1,1].
 * Example 2:
 * <p>
 * Input:[1,[4,[6]]]
 * Output:[1,4,6]
 * Explanation:By calling next repeatedly until hasNext returns false,
 *              the order of elements returned by next should be:[1,4,6].
 */

public class _341_Flatten_Nested_list_iterator implements Iterator<Integer> {
    int i = 0;
    int len;
    List<Integer> list;

    public _341_Flatten_Nested_list_iterator(List<NestedInteger> nestedList) {
        list = new ArrayList<>();
        addAll(nestedList);
        len = list.size();
    }

    @Override
    public Integer next() {
        return list.get(i++);
    }

    @Override
    public boolean hasNext() {
        return i < len;
    }

    private void addAll(List<NestedInteger> nestedList) {
        for (NestedInteger nest : nestedList) {
            if (nest.isInteger()) {
                list.add(nest.getInteger());
            } else {
                addAll(nest.getList());
            }
        }
    }

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }
}
