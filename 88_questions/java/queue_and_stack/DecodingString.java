package queue_and_stack;

import java.util.Stack;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/decode-string/description/">decode-string</a>
 */
public class DecodingString {

    /**
     * assistant stack
     * TC: O(n)  iterate over all characters in the string
     * SC: O(n)  assistant stack needs O(n) in extreme cases, such as 2[2[2[a]]]
     * @param s
     * @return
     */
    public String decodeString_assistantStack(String s) {
        int multi=0;
        StringBuilder res = new StringBuilder();
        Stack<Integer> multiStack = new Stack<>();
        Stack<StringBuilder> resStack = new Stack<>();

        for (char c:s.toCharArray()) {
            //opening bracket is encountered,the current repetition count and the string is pushed onto the stack
            if(c=='['){
                multiStack.push(multi);
                resStack.push(res);
                //reset the current repetition count and string
                multi=0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int curMulti = multiStack.pop();
                for(int i=0;i<curMulti;i++){
                    tmp.append(res);
                }
                res = resStack.pop().append(tmp);
            } else if (c>='0' && c<='9') {
                //It could be a multi-digit number
                multi = multi * 10 + (c-'0');
            }else {
                res.append(c);
            }
        }
        return res.toString();
    }


    /**
     * recursion
     * TC: O(n)
     * SC: O(n)
     * @param s
     * @return
     */
    public String decodingString_recursion(String s) {
        return dfs(s, 0)[0];
    }

    private String[] dfs(String s, int i) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        while (i < s.length()) {
            Character c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                multi = multi * 10 + (c - '0');
            } else if (c == '[') {
                //Decode the innermost string first, push into stack
                String[] tmp = dfs(s, i + 1);
                //update index
                i = Integer.valueOf(tmp[0]);

                //joint string
                while (multi != 0) {
                    res.append(tmp[1]);
                    //multi will eventually be cleared
                    multi--;
                }
            } else if (c == ']') {
                return new String[]{String.valueOf(i), res.toString()};
            } else {
                res.append(c);
            }
            i++;
        }
        return new String[]{res.toString()};
    }


}
