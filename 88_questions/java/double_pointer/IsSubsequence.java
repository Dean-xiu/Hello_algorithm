package double_pointer;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/is-subsequence/description/">is-subsequence</a>
 */
public class IsSubsequence {
    /**
     * Double pointer
     * TC: O(m+n)  m is the length of s, n is the length of t
     * SC: O(1)
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        for (int i = 0, j = 0; j < t.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) {
                if (++i == s.length()) {
                    return true;
                }
            }
        }
        return false;
    }
}
