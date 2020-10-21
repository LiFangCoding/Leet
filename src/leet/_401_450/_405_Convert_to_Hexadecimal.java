package leet._401_450;

public class _405_Convert_to_Hexadecimal {
    public String toHex(int num) {
        if (num == 0) return "0";

        StringBuilder sb = new StringBuilder();
        String nums = "0123456789abcdef";
        while (num != 0) {
            // System.out.println("num & 15 " + (num & 15));
            sb.append(nums.charAt(num & 15));
            num >>>= 4;
            // System.out.println("num is " + num);
        }
        return sb.reverse().toString();

    }
}
