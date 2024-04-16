package stimulation;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/add-strings/description/">add-strings</a>
 */
public class AddString {
    /**
     * Simulate vertical addition
     * TC: O(Max(m,n))  m,n are the length of num1,num2
     * SC: O(1)
     * @param num1
     * @param num2
     * @return
     */
    public String addStrings(String num1, String num2) {
        int i=num1.length()-1, j = num2.length() - 1;
        StringBuilder res = new StringBuilder();
        //Record whether a carry is required for the current round
        int add=0;

        while(i>=0 || j>=0 || add!=0){
            //Use 0 to complete the length mismatch
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = x + y + add;
            add = sum / 10;
            res.append(sum % 10);

            i--;
            j--;
        }
        return res.reverse().toString();
    }
}
