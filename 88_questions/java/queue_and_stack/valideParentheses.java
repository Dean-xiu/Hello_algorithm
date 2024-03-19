package java.queue_and_stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/valid-parentheses/description/">valid-parentheses</a>
 */
public class valideParentheses {
    static Map<Character, Character> pairs = new HashMap<Character, Character>() {{
        put('(', ')');
        put('[', ']');
        put('{', '}');
    }};

    /**
     * stack and hash
     * TC: O(n)  n is the length of s
     * SC: O(n+∣Σ∣)  ∣Σ∣ is character sets, there are only 6 character in this question
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        //parentheses appear in pairs and must not match if an odd number occurs
        if (s.length() % 2 != 0) return false;

        //use stack to store left parentheses
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (pairs.get(c) != null) {
                //put the open bracket on the stack
                stack.push(c);
            } else {
                //compare current character with closing bracket on the top of stack
                if (stack.isEmpty() || pairs.get(stack.peek()) != c) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
