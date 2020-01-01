package _101_150;

import java.util.ArrayList;
import java.util.List;

public class _119_Pascal_Triangle2 {
    public static void main(String[] args) {
        _119_Pascal_Triangle2 test = new _119_Pascal_Triangle2();

        System.out.println(test.getRow(1));
        System.out.println(test.getRow(2));
        System.out.println(test.getRow(3));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if (rowIndex < 0) {
            return res;
        }

        List<Integer> prev = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> cur = new ArrayList<>();

            if (i == 0) {
                cur.add(1);
                prev = cur;
            } else {
                cur.add(1);
                for (int j = 0; j < prev.size() - 1; j++) {
                    cur.add(prev.get(j) + prev.get(j + 1));
                }
                cur.add(1);
                prev = cur;
            }
        }

        return prev;
    }
}
