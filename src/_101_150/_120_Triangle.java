package _101_150;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * <p>
 * For example, given the following triangle
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * <p>
 * Note:
 * <p>
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class _120_Triangle {
    public static void main(String[] args) {
        _120_Triangle test = new _120_Triangle();
        List<List<Integer>> t = new ArrayList<>();
        t.add(Arrays.asList(2));
        t.add(Arrays.asList(3, 4));
        t.add(Arrays.asList(6, 5, 7));
        t.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(test.minimumTotal(t));
    }

    /**
     * f(i,j)=(i,j)+min(f(i-1,j),f(i-1,j-1))
     */
    public int minimumTotal(List<List<Integer>> t) {
        if (t == null || t.size() == 0) {
            return 0;
        }

        int len = t.size();
        List<Integer> prev = new ArrayList<>();
        List<Integer> cur;

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                prev = t.get(0);
            } else {
                cur = new ArrayList<>();

                for (int j = 0; j < t.get(i).size(); j++) {
                    if (j == 0) {
                        cur.add(prev.get(0) + t.get(i).get(j));
                    } else if (j == t.get(i).size() - 1) {
                        cur.add(prev.get(j - 1) + t.get(i).get(j));
                    } else {
                        cur.add(Math.min(prev.get(j), prev.get(j - 1)) + t.get(i).get(j));
                    }
                }
                prev = cur;
            }
        }

        return prev.stream().min(Comparator.comparing(Integer::valueOf)).get();
    }
}
