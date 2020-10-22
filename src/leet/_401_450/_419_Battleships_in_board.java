package leet._401_450;

public class _419_Battleships_in_board {
    // 统计数量。 完全不相连。 只需要统计左上角点的数量。 是x， 且上方和左方没有点
    public int countBattleships(char[][] board) {
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i > 0 && board[i - 1][j] == 'X') continue;
                if (j > 0 && board[i][j - 1] == 'X') continue;
                if (board[i][j] == 'X') res++;
            }
        }
        return res;
    }
}
