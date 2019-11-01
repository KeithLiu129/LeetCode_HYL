package LeetCode;

//329. Longest Increasing Path in a Matrix
//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

import java.util.Dictionary;

public class LC329_Longest_Increasing_Path_In_A_Matrix {
    private static final int[][] DIRECTIONS = {
            {-1, 0}, //up
            {1, 0}, // down
            {0, -1}, // left
            {0, 1} //right
    };
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return 0;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxSteps = 0;
        int[][] cache = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                maxSteps = Math.max(dfs(matrix, i, j, cache), maxSteps);
            }
        }

        return maxSteps;

    }

    private int dfs(int[][] matrix, int i, int j, int[][] cache) {
        if (cache[i][j] != 0) return cache[i][j];
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int[] dir : DIRECTIONS) {
            int offsetI = i + dir[0];
            int offsetJ = j + dir[1];

            if (offsetI >= 0
                    && offsetI < rows
                    && offsetJ >= 0
                    && offsetJ < cols
                    && matrix[offsetI][offsetJ] > matrix[i][j]) {
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, offsetI, offsetJ, cache));
            }
        }
        cache[i][j]++;
        return cache[i][j];
        }
    }
