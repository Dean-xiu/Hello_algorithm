package simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/zigzag-conversion/description/">zigzag-conversion</a>
 */
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows < 2 || s.length() < numRows) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();

        //Initializing rows
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        //put character into each row
        int i=0, flag=-1;
        for (char c : s.toCharArray()) {
            rows.get(i).append(c);
            //reverse the direction when get to the last row or first row
            if(i==0 || i==numRows-1)
                flag = -flag;

            i += flag;
        }

        //combine the final string
        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}
