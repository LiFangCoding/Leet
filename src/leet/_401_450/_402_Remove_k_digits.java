package leet._401_450;

public class _402_Remove_k_digits {
    // greedy
    public String removeKdigits(String num, int k) {
        k = Math.min(num.length(), k);

        StringBuilder sb = new StringBuilder();
        for (char c : num.toCharArray()) {
            while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) > c) {
                k--;
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(c);
        }

        // if k >0, delete the end
        while (k-- > 0) sb.deleteCharAt(sb.length() - 1);
        k = 0;
        while (k < sb.length() && sb.charAt(k) == '0') k++;
        if (k == sb.length()) sb.append('0');
        return sb.toString().substring(k);
    }
}
