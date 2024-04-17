package simulation;

import java.util.Stack;

/**
 * Question link
 *
 * @see <a href=""></a>
 */
public class ValidStackSequence {
    /**
     * simulate
     * TC: O(n)  n is the capacity of pushed/popped
     * SC: O(n)  n is the capacity of assist stack
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> assist = new Stack<>();
        int i=0;

        for (int num : pushed) {
            assist.push(num);
            while (!assist.isEmpty() && assist.peek() == popped[i]) {
                assist.pop();
                i++;
            }
        }
        return assist.isEmpty();
    }
}
