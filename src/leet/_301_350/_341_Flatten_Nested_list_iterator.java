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

public class _341_Flatten_Nested_list_iterator {
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }

    public class NestedIterator implements Iterator<Integer> {
        List<Integer> q;
        int k;

        // 看成树， 叶节点是整数
        public NestedIterator(List<NestedInteger> nestedList) {
            k = 0;
            q = new ArrayList<>();
            for (NestedInteger l : nestedList) {
                dfs(l);
            }
        }

        void dfs(NestedInteger l) {
            if (l.isInteger()) {
                q.add(l.getInteger());
            } else {
                for (NestedInteger v : l.getList()) {
                    dfs(v);
                }
            }
        }

        @Override
        public Integer next() {
            return q.get(k++);
        }

        @Override
        public boolean hasNext() {
            return k < q.size();
        }
    }
}
