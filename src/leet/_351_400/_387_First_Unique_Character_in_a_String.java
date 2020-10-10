package leet._351_400;

public class _387_First_Unique_Character_in_a_String {
    public int firstUniqChar(String s) {
        int[] map = new int[256];
        for (char c : s.toCharArray()) map[c]++;
        for (int i = 0; i < s.length(); i++) {
            if (map[s.charAt(i)] == 1) return i;
        }
        return -1;
    }
}
