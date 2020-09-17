package leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _1349_Max_Student_Exam {

    HashMap<String, Integer> map = new HashMap<>();
    char[][] seats;
    int[] dx = { -1, -1, -1, 1, 1, 1 };
    int[] dy = {0, -1, 1, 0, -1, 1};
    int m;
    int n;
    int res = 0;
    List<Integer> pathx;
    List<Integer> pathy;

    public static void main(String[] args) {
        _1349_Max_Student_Exam test = new _1349_Max_Student_Exam();
        char[][] seats = { {'#', '.', '#', '#', '.', '#'}, { '.', '#', '#', '#', '#', '.' }, { '#', '.', '#', '#', '.', '#' } };
        System.out.println(test.maxStudents(seats));
    }

    public int maxStudents(char[][] seats) {
        this.seats = seats;
        m = seats.length;
        n = seats[0].length;
        pathx = new ArrayList<>();
        pathy = new ArrayList<>();

        search();
        return res;
    }

    private void search() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (seats[i][j] == '#') {
                    continue;
                } else {
                    if (valid(i, j)) {
                        pathx.add(i);
                        pathy.add(j);
                        seats[i][j] = '#';
                        res = Math.max(res, pathx.size());
                        System.out.println("add i, j is " + i + " " + j);
                        System.out.println("add res is " + res);

                        search();
                        map.put(i + "->" + j, pathx.size());

                        pathx.remove(pathx.size() - 1);
                        pathy.remove(pathy.size() - 1);
                        seats[i][j] = '.';
                        System.out.println("delete i, j is " + i + "" + j);
                        System.out.println("delete res is " + res);
                    }
                }
            }
        }
    }

    private boolean valid(int x, int y) {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }

        for (int i = 0; i < pathx.size(); i++) {
            int prevx = pathx.get(i);
            int prevy = pathy.get(i);

            for (int k = 0; k < dx.length; k++) {
                int canseex = x + dx[k];
                int canseey = y + dy[k];

                if (prevx == canseex && prevy == canseey) {
                    return false;
                }
            }
        }

        return true;
    }

}
