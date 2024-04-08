package hash_table;

import java.util.HashMap;
import java.util.Map;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/palindrome-permutation-lcci/description/">palindrome-permutation</a>
 */
public class PalindromePermutation {
    /**
     * HashTable
     * TC: O(n)  n is the length of the string, iterate twice, the actual time cost is O(n+n)=O(2n)=O(n)
     * SC: O(n)  n is the size of hash table
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        //Count the number of times each character appears
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        //Iterate to see if only a single character appears an odd number of times
        int odd=0;
        for (int val : map.values()) {
            if (val % 2 != 0) {
                if (++odd > 1) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * count
     * TC: O(n)  n is the length of the string
     * SC: O(1)  the size of map is 128*32bit
     * @param s
     * @return
     */
    public boolean canPermutePalindrome_count(String s) {
        //Count the number of odd occurrences of a character
        int count = 0;
        int[] map = new int[128];

        for (char c : s.toCharArray()) {
            if ((map[c]++ & 1) == 1) {
                count--;
            } else {
                count++;
            }
        }
        return count <= 1;
    }
}
