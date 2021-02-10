package leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A website domain like "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the next level, we have "leetcode.com", and at the lowest level, "discuss.leetcode.com". When we visit a domain like "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.
 *
 * Now, call a "count-paired domain" to be a count (representing the number of visits this domain received), followed by a space, followed by the address. An example of a count-paired domain might be "9001 discuss.leetcode.com".
 *
 * We are given a list cpdomains of count-paired domains. We would like a list of count-paired domains, (in the same format as the input, and in any order), that explicitly counts the number of visits to each subdomain.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subdomain-visit-count
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Example 1:
 * Input:
 * ["9001 discuss.leetcode.com"]
 * Output:
 * ["9001 discuss.leetcode.com", "9001 leetcode.com", "9001 com"]
 * Explanation:
 * We only have one website domain: "discuss.leetcode.com". As discussed above, the subdomain "leetcode.com" and "com" will also be visited. So they will all be visited 9001 times.
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subdomain-visit-count
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _811_Subdomain_Visit_Count {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cp : cpdomains) {
            String[] cpdomain = cp.split(" ");
            int count = Integer.parseInt(cpdomain[0]);
            // record each
            for (String dom : getDomains(cpdomain[1])) {
                map.put(dom, map.getOrDefault(dom, 0) + count);
            }
        }

        List<String> res = new ArrayList<>();
        for (String key : map.keySet()) {
            res.add(map.get(key) + " " + key);
        }
        return res;
    }

    private List<String> getDomains(String url) {
        // start from right to left, get all domains int the list
        List<String> res = new ArrayList<>();
        int len = url.length();

        int j = len - 1;
        while (j >= 0) {
            while (j >= 0 && url.charAt(j) != '.') j--;
            res.add(url.substring(j + 1));
            j--;
        }

        return res;
    }
}
