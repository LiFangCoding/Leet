package _51_100;

public class _67_Add_Binary {
    public String addBinary(String a, String b) {
        String res = "";

        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = carry;
            sum += (i >= 0) ? a.charAt(i) - '0' : 0;
            sum += (j >= 0) ? b.charAt(j) - '0' : 0;
            res = (sum % 2) + res;
            carry = sum / 2;
        }

        if (carry != 0) {
            res = carry + res;
        }
        return res;
    }
}
