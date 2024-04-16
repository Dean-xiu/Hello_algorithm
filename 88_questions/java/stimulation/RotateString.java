package stimulation;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/rotate-string/description/">rotate-string</a>
 */
public class RotateString {
    /**
     * Stimulate
     * TC: O(n^2)  n is the length of s or goal
     * SC: O(1)
     * @param s
     * @param goal
     * @return
     */
    public boolean rotateString_stimulate(String s, String goal) {
        int m = s.length(), n = goal.length();

        if(m!=n)
            return false;

        //fixed the number of shift bits
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            //Compare each character after i bit rotation
            for (int j = 0; j < n; j++) {
                if (s.charAt((i + j) % n) != goal.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if(flag)
                return true;
        }
        return false;
    }


    /**
     * Search Substring
     * TC: O(n)  the TC of contains() is O(n)
     * SC: O(n)  the SC of contains() is O(n)
     * @param s
     * @param goal
     * @return
     */
    public boolean rotateString_searchSubString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}
