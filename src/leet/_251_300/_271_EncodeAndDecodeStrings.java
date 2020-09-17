package leet._251_300;

import java.util.ArrayList;
import java.util.List;

/**
 * Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
 * <p>
 * Machine 1 (sender) has the function:
 * <p>
 * string encode(vector<string> strs) {
 * // ... your code
 * return encoded_string;
 * }
 * Machine 2 (receiver) has the function:
 * vector<string> decode(string s) {
 * //... your code
 * return strs;
 * }
 * So Machine 1 does:
 * <p>
 * string encoded_string = encode(strs);
 * and Machine 2 does:
 * <p>
 * vector<string> strs2 = decode(encoded_string);
 * strs2 in Machine 2 should be the same as strs in Machine 1.
 * <p>
 * Implement the encode and decode methods.
 * <p>
 *  
 * <p>
 * Note:
 * <p>
 * The string may contain any possible characters out of 256 valid ascii characters. Your algorithm should be generalized enough to work on any possible characters.
 * Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
 * Do not rely on any library method such as eval or serialize methods. You should implement your own encode/decode algorithm.
 */
public class _271_EncodeAndDecodeStrings {
    //TODO: haojun need more time
    // Encodes a list of strings to a single string.

    /**
     * 28ms
     * T = n
     *
     * @param strs
     * @return
     */
    public String encode(List<String> strs) {
        StringBuilder ans = new StringBuilder();

        for (String s : strs) {
            for (char c : s.toCharArray()) {
                // : itself
                if (c == ':') {
                    ans.append("::");
                } else {                         //ordinary character
                    ans.append(c);
                }
            }
            ans.append(":;");                    // ; connector
        }

        return ans.toString();
    }

    /**
     * @param str a string
     * @return dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // Write your code here
        List<String> ans = new ArrayList<>();
        char[] sc = str.toCharArray();
        StringBuilder item = new StringBuilder();

        int i = 0;
        while (i < str.length()) {
            if (sc[i] == ':') {                  //escape
                if (sc[i + 1] == ';') {          // ; connector
                    ans.add(item.toString());
                    item = new StringBuilder();
                    i += 2;
                } else {                         // : itself
                    item.append(sc[i + 1]);
                    i += 2;
                }
            } else {                             //ordinary character
                item.append(sc[i]);
                i += 1;
            }
        }
        return ans;
    }
}
