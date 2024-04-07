package hash_table;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/valid-anagram/description/">valid-anagram</a>
 */
public class ValidAnagram {
    /**
     * HashTable
     * TC: O(m+n)  m is the length of s, n is the length of t
     * SC: O(1)  hash table store at most the entire alphabet
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_hashtable(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();

        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Character c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        return map.values().stream().allMatch(value -> value == 0);
    }


    /**
     * Sort
     * TC: O(nlogn)  n is the length of s, nlogn is the TC of sort, the total is O(nlogn + n)=O(nlogn)
     * SC: O(logn)  logn is the SC of sort
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_sort(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);

        return Arrays.equals(sArray, tArray);
    }
}
