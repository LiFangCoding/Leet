package _51_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * <p>
 * Example:
 * <p>
 * Input: "25525511135"
 * Output: ["255.255.11.135", "255.255.111.35"]
 */
public class _93_Restore_IP_Addresses {
    public static void main(String[] args) {
        _93_Restore_IP_Addresses test = new _93_Restore_IP_Addresses();
        System.out.println(test.restoreIpAddresses("25525511135"));

        System.out.println(Integer.parseInt("01"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }

        int len = s.length();
        if (len < 4 || len > 12) {
            return res;
        }

        helper(s, 0, 0, "", res);
        return res;
    }

    private void helper(String s, int start, int count, String chosen, List<String> res) {
        if (count == 4 && start == s.length()) {
            res.add(chosen.substring(0, chosen.length() - 1));
            return;
        }

        /**
         * Important prune. Increase from 10% to 90 %
         */
        if (count > 4) {
            return;
        }

        for (int i = 1; i <= 3 && start + i <= s.length(); i++) {
            String str = s.substring(start, start + i);
            /**
             * find valid chosen
             * 01 is not correct
             */
            if (str.charAt(0) == '0' && str.length() > 1) {
                continue;
            }
            int num = Integer.parseInt(str);
            /**
             * !! only 0 is ok
             */
            if (num >= 0 && num <= 255) {
                helper(s, start + i, count + 1, chosen + num + '.', res);
            }
        }
    }
}
