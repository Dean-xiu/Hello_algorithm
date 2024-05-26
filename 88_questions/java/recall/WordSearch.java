package recall;

/**
 * Question link
 *
 * @see <a href="https://leetcode.cn/problems/word-search/description/">word-search</a>
 */
public class WordSearch {
    /**
     * Recall
     * TC: O(3^kMN)  K is the length of word, M is the number of rows of board, N is the number of columns of board
     * SC: O(K)  The recursion depth in the search process does not exceed K, The worst case K is equal to MN
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for(int j=0;j<board[0].length;j++){
                if (dfs(board, chars, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] chars, int i, int j, int k) {
        //reach the boundary
        if(i>=board.length || i<0 || j>=board[0].length || j<0 || board[i][j]!=chars[k]) return false;
        if(k==chars.length-1) return true;

        board[i][j] = '\0';
        //finds the next character from an adjacent position
        boolean res = dfs(board, chars, i + 1, j, k + 1) || dfs(board, chars, i - 1, j, k + 1)
                || dfs(board, chars, i, j + 1, k + 1) || dfs(board, chars, i, j - 1, k + 1);
        //restore the board[i][j]
        board[i][j]=chars[k];
        return res;
    }
}
