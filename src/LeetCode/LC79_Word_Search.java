package LeetCode;

//79. Word Search
//https://leetcode.com/problems/word-search/

public class LC79_Word_Search {
    public boolean exist(char[][] board, String word) {
        //c.c.
        if (board == null || board.length == 0 || board[0] == null || board[0].length == 0) return false;
        if (word.length() == 0) return true;

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if(dfs(board, word, 0, i, j)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int i, int j) {
        if (index == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index))
            return false;
        char temp = board[i][j];
        board[i][j] = '$';
        boolean res = dfs(board, word, index + 1, i - 1, j)
                || dfs(board, word, index + 1, i + 1, j)
                || dfs(board, word, index + 1, i, j - 1)
                || dfs(board, word, index + 1, i, j + 1);
        board[i][j] = temp;
        return res;
    }
}
