package _251_300;

/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 * <p>
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 * <p>
 * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * <p>
 * Example:
 * <p>
 * Given n = 5, and version = 4 is the first bad version.
 * <p>
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * <p>
 * Then 4 is the first bad version. 
 */
public class _278_FirstBadVersion {
    /**
     * t t t f f
     * <p>
     * res = 4
     *
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        if (n <= 0) {
            return 0;
        }

        int l = 1, r = n;

        while (l + 1 < r) {
            int mid = l + (r - l) / 2;

            if (isBadVersion(mid)) {
                r = mid;
            } else {
                l = mid;
            }
        }

        if (isBadVersion(l)) {
            return l;
        }

        if (isBadVersion(r)) {
            return r;
        }

        return -1;
    }

    // example api
    private boolean isBadVersion(int version) {
        return false;
    }
}
