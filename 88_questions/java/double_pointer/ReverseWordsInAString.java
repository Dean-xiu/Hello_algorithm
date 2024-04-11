package double_pointer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/reverse-words-in-a-string/description/">reverse-words-in-a-string</a>
 */
public class ReverseWordsInAString {
    /**
     * Language features
     * TC: O(n)  the number of the words
     * SC: O(n)
     * @param s
     * @return
     */
    public String reverseWords_LanguageFeatures(String s) {
        List<String> words = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(words);
        return String.join(" ", words);
    }


    /**
     * Double Pointer
     * TC: O(n) the length of the string
     * SC: O(n)
     * @param s
     * @return
     */
    public String reverseWords_DoublePointer(String s){
        s = s.trim();
        int i = s.length()-1, j = s.length()-1;
        StringBuilder res = new StringBuilder();

        while (i >= 0) {
            //skip to the first letter of word
            while (i>=0 && s.charAt(i)!=' ')
                i--;
            res.append(s.substring(i + 1, j + 1)).append(" ");

            //skip to the end letter of the next word
            while (i>=0 && s.charAt(i)==' ')
                i--;
            j=i;
        }
        return res.toString().trim();
    }
}
