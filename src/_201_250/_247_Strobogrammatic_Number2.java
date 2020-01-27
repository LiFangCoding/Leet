package _201_250;

import java.util.ArrayList;
import java.util.List;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * <p>
 * Find all strobogrammatic numbers that are of length = n.
 * <p>
 * Example:
 * <p>
 * Input:  n = 2
 * Output: ["11","69","88","96"]
 */
public class _247_Strobogrammatic_Number2 {
    List<String> res;
    StringBuilder sb;
    char[] nums = new char[]{'0', '1', '8', '6', '9'};
    char[] rotated = new char[]{'0', '1', '8', '9', '6'};

    public static void main(String[] args) {
        _247_Strobogrammatic_Number2 test = new _247_Strobogrammatic_Number2();
        System.out.println(test.findStrobogrammatic(3));
        System.out.println(test.findStrobogrammatic(2));
        System.out.println(test.findStrobogrammatic(1));
    }

    public List<String> findStrobogrammatic(int n) {
        res = new ArrayList<>();
        sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append(' ');
        }

        search(n, 0, n - 1);
        return res;
    }

    //     map.put('6', '9');
//     map.put('9', '6');
//     map.put('8', '8');
//     map.put('0', '0');
//     map.put('1', '1');
    private void search(int n, int l, int r) {
        if (l > r) {
            res.add(sb.toString());
            return;
        }
        if (l == r) {
            int endIdx = 2;
            for (int i = 0; i <= endIdx; i++) {
                sb.setCharAt(l, nums[i]);
                res.add(sb.toString());
//                sb.deleteCharAt(l);
            }
            return;
        }

        int index = l == 0 ? 1 : 0;
        for (int i = index; i < nums.length; i++) {
            sb.setCharAt(l, nums[i]);
            sb.setCharAt(r, rotated[i]);
            search(n, l + 1, r - 1);
//            sb.deleteCharAt(l);
//            sb.deleteCharAt(r);
        }
    }
}
