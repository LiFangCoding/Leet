package leet._101_150;

import java.util.ArrayList;
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

    /**
     * 11ms
     * T= n
     */
    class Sol_inPlace {
        public int minimumTotal(List<List<Integer>> T) {
            int rows = T.size();
            for (int row = 1; row < rows; row++) {
                for (int col = 0; col < T.get(row).size(); col++) {
                    int minSum = Integer.MAX_VALUE;

                    int curVal = T.get(row).get(col);

                    if (col - 1 >= 0) {
                        minSum = Math.min(minSum, T.get(row - 1).get(col - 1) + curVal);
                    }

                    // !!! row - 1 size
                    if (col < T.get(row - 1).size()) {
                        minSum = Math.min(minSum, T.get(row - 1).get(col) + curVal);
                    }

                    T.get(row).set(col, minSum);
                }
            }

            int ans = Integer.MAX_VALUE;
            for (int val : T.get(rows - 1)) {
                ans = Math.min(ans, val);
            }

            return ans;
        }
    }

    class Sol_copy {
        /**
         * 14ms
         * T = n
         * S = n
         * f(i,j)=(i,j)+min(f(i-1,j),f(i-1,j-1))
         */
        public int minimumTotal(List<List<Integer>> T) {
            List<List<Integer>> f = new ArrayList<>();

            for (int row = 0; row < T.size(); row++) {
                List<Integer> sum = new ArrayList<>();

                for (int col = 0; col < T.get(row).size(); col++) {
                    int curVal = T.get(row).get(col);
                    if (row == 0) {
                        sum.add(curVal);
                    } else {
                        if (col == 0) {
                            sum.add(f.get(row - 1).get(col) + curVal);
                        } else if (col == T.get(row).size() - 1) {
                            sum.add(f.get(row - 1).get(col - 1) + curVal);
                        } else {
                            int left = f.get(row - 1).get(col - 1) + curVal;
                            // System.out.println("row is " + row + "col is " + col);
                            // System.out.println("row - 1 cols are " + f.get(row - 1).size());

                            int right = f.get(row - 1).get(col) + curVal;
                            sum.add(Math.min(left, right));
                        }
                    }
                }

                // pay attention. Thhe sum should be ourside of for col loop
                f.add(sum);
            }

            int ans = f.get(T.size() - 1).get(0);

            for (int val : f.get(T.size() - 1)) {
                ans = Math.min(val, ans);
            }

            return ans;
        }
    }

}
