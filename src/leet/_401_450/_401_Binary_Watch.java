package leet._401_450;

import java.util.ArrayList;
import java.util.List;

public class _401_Binary_Watch {
    //枚举
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        char[] str = new char[10];
        for (int i = 0; i < 1 << 10; i++) {
            int s = 0;
            for (int j = 0; j < 10; j++) {
                if ((i >> j & 1) == 1) {
                    s++;
                }
            }
            if (s == num) {
                int a = i >> 6, b = i & 63;
                if (a < 12 && b < 60) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(a);
                    sb.append(":");
                    if (b < 10) {
                        sb.append("0");
                    }
                    sb.append(b);
                    res.add(sb.toString());
                }
            }
        }
        return res;
    }
}
