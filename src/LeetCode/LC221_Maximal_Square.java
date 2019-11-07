package LeetCode;

//221. Maximal Square
//https://leetcode.com/problems/maximal-square/

public class LC221_Maximal_Square {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;

        int row = matrix.length;
        int col = matrix[0].length;

        int[][] dp = new int[row][col];
        int size = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || j ==0 || matrix[i][j] == '0') {
                    dp[i][j] = matrix[i][j] - '0';
                }else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
                size = size > dp[i][j] ? size : dp[i][j];
            }
        }
        return size * size;
    }
}
