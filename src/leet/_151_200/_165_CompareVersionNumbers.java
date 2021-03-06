package leet._151_200;

/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0.
 * <p>
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * <p>
 * The . character does not represent a decimal point and is used to separate number sequences.
 * <p>
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * <p>
 * You may assume the default revision number for each level of a version number to be 0. For example, version number 3.4 has a revision number of 3 and 4 for its first and second level revision number. Its third and fourth level revision number are both 0.
 * <p>
 *  
 * <p>
 * Example 1:
 * <p>
 * Input: version1 = "0.1", version2 = "1.1"
 * Output: -1
 * Example 2:
 * <p>
 * Input: version1 = "1.0.1", version2 = "1"
 * Output: 1
 * Example 3:
 * <p>
 * Input: version1 = "7.5.2.4", version2 = "7.5.3"
 * Output: -1
 * Example 4:
 * <p>
 * Input: version1 = "1.01", version2 = "1.001"
 * Output: 0
 * Explanation: Ignoring leading zeroes, both “01” and “001" represent the same number “1”
 * Example 5:
 * <p>
 * Input: version1 = "1.0", version2 = "1.0.0"
 * Output: 0
 * Explanation: The first version number does not have a third level revision number, which means its third level revision number is default to "0"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compare-version-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _165_CompareVersionNumbers {
    class Sol_ac {
        public int compareVersion(String v1, String v2) {
            for (int i = 0, j = 0; i < v1.length() || j < v2.length(); ) {
                int a = i, b = j;
                while (a < v1.length() && v1.charAt(a) != '.')
                    a++;
                while (b < v2.length() && v2.charAt(b) != '.')
                    b++;
                int x = a == i ? 0 : Integer.parseInt(v1.substring(i, a));
                int y = b == j ? 0 : Integer.parseInt(v2.substring(j, b));
                if (x > y)
                    return 1;
                if (x < y)
                    return -1;
                i = a + 1;
                j = b + 1;
            }
            return 0;
        }
    }

    public int compareVersion(String version1, String version2) {
        /**
         * java里面以. \ |为分隔符时，需要加上\，即\. \\ \|才能正确分割
         */
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");

        int len = Math.max(nums1.length, nums2.length);

        for (int i = 0; i < len; i++) {
            int v1 = i < nums1.length ? Integer.parseInt(nums1[i]) : 0;
            int v2 = i < nums2.length ? Integer.parseInt(nums2[i]) : 0;
            if (v1 > v2) {
                return 1;
            }
            if (v1 < v2) {
                return -1;
            }
        }

        return 0;
    }

    public int compareVersion_twoPointers(String version1, String version2) {
        int i = 0, j = 0;
        while (i < version1.length() || j < version2.length()) {
            /**
             * Important: if reach end, v1 and v2 can be 0. no exception.
             */
            int v1 = 0, v2 = 0;
            while (i < version1.length() && version1.charAt(i) != '.') {
                v1 = v1 * 10 + version1.charAt(i++) - '0';
            }
            while (j < version2.length() && version2.charAt(j) != '.') {
                v2 = v2 * 10 + version2.charAt(j++) - '0';
            }

            if (v1 > v2) {
                return 1;
            }

            if (v1 < v2) {
                return -1;
            }

            i++;
            j++;
        }
        return 0;
    }
}
