package double_pointer;

import java.util.HashMap;
import java.util.Map;

/**
 * Question link
 *
 * @see <a href=""></a>
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * Hash table + Double String
     * TC: O(n)  n is the length of the string
     * SC: O(1)  the size of ascii code sets
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dics = new HashMap<>();
        int i = -1, res = 0, len = s.length();

        for (int j = 0; j < len; j++) {
            //encounter repeat character, discard the last longest substring
            if (dics.containsKey(s.charAt(j)))
                i = Math.max(i, dics.get(s.charAt(j)));
            dics.put(s.charAt(j), j);

            //update result
            res = Math.max(res, j - i);
        }
        return res;
    }
}
