package simulation;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/rotate-image/description/">rotate-image</a>
 */
public class RotateImage {
    /**
     * assist Matrix
     * TC: O(n^2)  Iterate over all elements of the matrix
     * SC: O(n^2)  the size of assist matrix
     * @param matrix
     */
    public void rotate_assistMatrix(int[][] matrix) {
        int n = matrix.length;
        int[][] tmp = new int[n][];

        //deep clone matrix->tmp
        for (int i = 0; i < n; i++) {
            tmp[i] = matrix[i].clone();
        }

        //rotate
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //column j -> j row, row i -> column n-1-i
                matrix[j][n - 1 - i] = tmp[i][j];
            }
        }
    }


    /**
     * Modify in placve
     * TC: O(n^2)  each element of matrix is rotated
     * SC: O(1)  variable tmp used constant space
     * @param matrix
     */
    public void rotate_modifyInPlace(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                //A,B,C,D are the four corners of matrix rotated clockwise
                //store A(matrix[i][j]) with tmp
                int tmp = matrix[i][j];
                //A->B
                matrix[i][j] = matrix[n - 1 - j][i];
                //B->C
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                //C->D
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                //D->A
                matrix[j][n - 1 - i] = tmp;
            }
        }

    }
}
