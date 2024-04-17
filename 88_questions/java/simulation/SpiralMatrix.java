package simulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/spiral-matrix/description/">spiral-matrix</a>
 */
public class SpiralMatrix {
    /**
     * simulation
     * TC: O(mn)  m is the number of rows, n is the number of columns
     * SC: O(1)  l,r,t,b  four constants
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length==0)
            return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        int l = 0, r = matrix[0].length-1, t = 0, b = matrix.length - 1;
        while (true) {
            //left->right
            for (int i = l; i <= r; i++) res.add(matrix[t][i]);
            //Finish a row and the upper bound drops
            if (++t > b) break;

            //top->bottom
            for (int i = t; i <= b; i++) res.add(matrix[i][r]);
            if (--r < l) break;

            //right->left
            for (int i = r; i >= l; i--) res.add(matrix[b][i]);
            if (--b < t) break;

            //bottom->top
            for (int i = b; i >= t; i--) res.add(matrix[i][l]);
            if(++l > r) break;
        }
        return res;
    }
}
