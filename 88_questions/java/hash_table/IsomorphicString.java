package hash_table;

import java.util.HashMap;
import java.util.Map;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/isomorphic-strings/description/">isomorphic-strings</a>
 */
public class IsomorphicString {
    /**
     * HashTable
     * TC: O(n)  n is the length of the string
     * SC: O(∣Σ∣)  Σ is the size of character sets
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<>();
        Map<Character, Character> t2s = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x,y);
            t2s.put(y,x);
        }
        return true;
    }
}
