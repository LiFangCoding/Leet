package _1_50;

/**
 *
 */
public class _37_SudokuSolver {
//    public boolean isValidSudoku(char[][] board) {
//        int leftCount = 0;
//        for (char[] chars : board) {
//            for (char c : chars) {
//                if (c == '.') {
//                    leftCount++;
//                }
//            }
//        }
//
//        return sudokuHelper(board, leftCount);
//    }
//
//    private boolean sudokuHelper(char[][] board, int leftCount) {
//        if (leftCount == 0) {
//            return true;
//        }
//
//        int rows = 9;
//        int cols = 9;
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (board[i][j] == '.') {
//                    for (int val = 1; val <= 9; val++) {
//                        board[i][j] = (char) ('0' + val);
//                        if (isValid(board, i , j)) {
//                            /**
//                             * backtrack here
//                             */
//                            System.out.println("Current board for " + i + " " + j + "is ");
//                            System.out.println(Arrays.deepToString(board));
//                            if (sudokuHelper(board, leftCount - 1)) {
//                                return true;
//                            }
//                        }
//                        board[i][j] = '.';
//                    }
//                }
//            }
//        }
//
//        return false;
//    }
//
//    /**
//     * return if it meets the 3 rules
//     */
//    private boolean isValid(char[][] board, int i, int j) {
//        Set<Integer> set = new HashSet<>();
//
//        for (int col = 0; col < 9; col++) {
//            if (board[i][col] != '.') {
//                int val = board[i][col] - '0';
//
//                if (set.contains(val)) {
//                    return false;
//                }
//
//                set.add(val);
//            }
//        }
//
//        // clear make no cache for row
//        set.clear();
//
//        for (int row = 0; row < 9; row++) {
//            if (board[row][j] != '.') {
//                int val = board[row][j] - '0';
//
//                if (set.contains(val)) {
//                    return false;
//                }
//
//                set.add(val);
//            }
//        }
//
//        set.clear();
//
//        /**
//         * 0,1,2 3,4,5 6,7,8
//         *
//         */
//
//        int subboxRow = (i / 3) * 3;
//        int subboxCol = (j / 3) * 3;
//
//        for (int i1 = subboxRow; i1 < subboxRow + 3; i1++) {
//            for (int j1 = subboxCol; j1 < subboxCol + 3; j1++) {
//                if (board[i1][j1] != '.') {
//                    int val = board[i1][j1] - '0';
//
//                    if (set.contains(val)) {
//                        return false;
//                    }
//
//                    set.add(val);
//                }
//            }
//        }
//
//        return true;
//    }
}
