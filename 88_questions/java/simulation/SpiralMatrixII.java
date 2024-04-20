package simulation;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/spiral-matrix-ii/description/">spiral-matrix-ii</a>
 */
public class SpiralMatrixII {
    /**
     * simulation
     * TC: O(n^2)  the size of matrix is n*n
     * SC: O(1)
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int l=0,r=n-1,t=0,b=n-1;
        int[][] res = new int[n][n];

        int num=1;
        while (num <= n * n) {
            //left->right
            for (int i = l; i <= r; i++) res[t][i] = num++;
            t++;

            //top->bottom
            for (int i = t; i <= b; i++) res[i][r] = num++;
            r--;

            //right->left
            for (int i = r; i >= l; i--) res[b][i] = num++;
            b--;

            //bottom->top
            for (int i = b; i >= t; i--) res[i][l] = num++;
            l++;
        }
        return res;
    }
}
