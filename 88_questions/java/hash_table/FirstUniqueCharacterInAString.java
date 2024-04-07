package hash_table;

import java.util.HashMap;
import java.util.Map;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/first-unique-character-in-a-string/description/">first-unique-character-in-a-string</a>
 */
public class FirstUniqueCharacterInAString {
    /**
     * HashTable  store frequency of each character in the string
     * TC: O(n)  n is the length of the string
     * SC: O(∣Σ∣)  ∣Σ∣ is the size of character sets
     * @param s
     * @return
     */
    public int firstUniqChar_storeFrequency(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }


    /**
     * HashTable  store index of first unique character in the string
     * TC: O(n)  actually TC is O(n)+O(∣Σ∣), but O(∣Σ∣) is less than 26, so it can be ignored
     * SC: O(∣Σ∣)   Σ is the size of character sets
     * @param s
     * @return
     */
    public int firstUniqChar_storeIndex(String s) {
        Map<Character, Integer> indexMap = new HashMap<>();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (indexMap.containsKey(c)) {
                indexMap.put(c, -1);
            }else {
                indexMap.put(c, i);
            }
        }

        int first = n;
        for (Map.Entry<Character, Integer> entry : indexMap.entrySet()) {
            int pos = entry.getValue();
            if (pos != -1 && pos < first) {
                first = pos;
            }
        }
        if (first == n) {
            first = -1;
        }
        return first;
    }



}
