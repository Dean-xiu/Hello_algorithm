package search;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/first-bad-version/description/">first-bad-version</a>
 */
public class FirstBadVersion {
    static boolean isBadVersion(int version) {
        if (version == 2) {
            return true;
        }
        return false;
    }

    /**
     * Binary search
     * TC: O(logn)
     * SC: O(1)
     * @param n
     * @return
     */
    public static int firstBadVersion(int n) {
        int l = 1, r = n;
        while (l <= r) {
            int mid = (r - l) / 2 + l;
            //mid is the bad version, but maybe not the first bad version
            if (isBadVersion(mid)) {
                // the right version range is [l,mid-1]
                r = mid - 1;
            } else {
                //the mid is right version, that's mean the range of bad version is [mid+1,r]
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(firstBadVersion(3));
    }
}
