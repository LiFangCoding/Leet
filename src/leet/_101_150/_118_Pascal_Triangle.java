package leet._101_150;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * <p>
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * <p>
 * Input: 5
 * Output:
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class _118_Pascal_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();

            if (i == 1) {
                row.add(1);
                res.add(row);
            } else {
                List<Integer> lastRow = res.get(res.size() - 1);
                row.add(1);
                for (int j = 0; j < lastRow.size() - 1; j++) {
                    row.add(lastRow.get(j) + lastRow.get(j + 1));
                }
                row.add(1);
                res.add(row);
            }
        }

        return res;
    }
}
