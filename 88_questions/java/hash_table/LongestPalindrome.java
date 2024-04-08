package hash_table;

import java.util.HashMap;
import java.util.Map;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/longest-palindrome/description/">longest-palindrome</a>
 */
public class LongestPalindrome {
    /**
     * HashTable
     * TC: O(n)  n is the length of the string
     * SC: O(1)  the number of ascii code is 128, so O(128)=O(1)
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int odd = 0;

        //count the frequency of each character
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int val : map.values()) {
            //the current count goes down even
            int rem = val % 2;
            res += val - rem;

            //The current character appears an odd number of times, and odd is set to 1
            if(rem==1)
                odd = 1;
        }
        return res + odd;
    }
}
