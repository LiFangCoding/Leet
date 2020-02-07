package _251_300;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:
 * <p>
 * a) it                      --> it    (no abbreviation)
 * <p>
 * 1
 * ↓
 * b) d|o|g                   --> d1g
 * <p>
 * 1    1  1
 * 1---5----0----5--8
 * ↓   ↓    ↓    ↓  ↓
 * c) i|nternationalizatio|n  --> i18n
 * <p>
 * 1
 * 1---5----0
 *      ↓   ↓    ↓
 * d) l|ocalizatio|n          --> l10n
 * Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
 * <p>
 * Example:
 * <p>
 * Given dictionary = [ "deer", "door", "cake", "card" ]
 * <p>
 * isUnique("dear") -> false
 * isUnique("cart") -> true
 * isUnique("cane") -> false
 * isUnique("make") -> true
 */
public class _288_UniqueWordAbbre {
    //TODO: cannot understand the prolbemk
    Map<String, Boolean> map;
    Set<String> set;

    public _288_UniqueWordAbbre(String[] dict) {
        set = new HashSet<>();
        for (String s : dict) {
            if (s != null && s.length() >= 2) {
                set.add(s);
            }
        }
    }

    // len(s) >= 2
    private String getAbbre(String s) {
        int len = s.length();

        if (len == 2) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        sb.append(len - 2);
        sb.append(s.charAt(len - 1));
        return sb.toString();
    }
}
