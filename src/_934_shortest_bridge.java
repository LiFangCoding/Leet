import java.util.LinkedList;
import java.util.Queue;

/**
 * In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)
 * <p>
 * Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
 * <p>
 * Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: [[0,1],[1,0]]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 * Example 3:
 * <p>
 * Input: [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 */
public class _934_shortest_bridge {
    Queue<Integer> qx;
    Queue<Integer> qy;
    // mark for land
    int landMark = 2;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        _934_shortest_bridge test = new _934_shortest_bridge();
        int[][] A = {{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}};
        System.out.println(test.shortestBridge(A));
    }

    public int shortestBridge(int[][] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        qx = new LinkedList<>();
        qy = new LinkedList<>();

        // need this one. Else error
        boolean find = false;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j);
                    find = true;
                    break;
                }
            }
            // break is here for outside loop
            if (find) {
                break;
            }
        }

        // bfs from all marked as 2 to find the node is 1
        int level = -1;
        while (!qx.isEmpty()) {
            level++;
            int size = qx.size();
            for (int i = 0; i < size; i++) {
                int x = qx.remove();
                int y = qy.remove();

                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (nx >= 0 && nx < A.length && ny >= 0 && ny < A[0].length) {
                        if (A[nx][ny] == landMark) {
                            continue;
                        }

                        if (A[nx][ny] == 0) {
                            qx.add(nx);
                            qy.add(ny);
                            // need to mark it
                            A[nx][ny] = landMark;
                        } else if (A[nx][ny] == 1) {
                            return level;
                        }
                    }
                }
            }
        }

        // need return
        return -1;
    }

    // add all island 1 into queue
    private void dfs(int[][] A, int x, int y) {
        qx.add(x);
        qy.add(y);
        A[x][y] = landMark;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < A.length &&
                    ny >= 0 && ny < A[0].length &&
                    // here is nx ny
                    A[nx][ny] == 1) {
                dfs(A, nx, ny);
            }
        }
    }
}
