package LeetCode;

//130. Surrounded Regions
//https://leetcode.com/problems/surrounded-regions/

import java.util.LinkedList;
import java.util.Queue;

public class LC130_Surrounded_Regions {
    private int[][] direction = {
        {-1, 0},
        {1, 0},
        {0, -1},
        {0, 1}
    };
    public void solve(char[][] board) {
        if (board == null || board.length == 0|| board[0] == null || board[0].length == 0) return;

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((i == 0 || i == row - 1 || j == 0 || j == col - 1) && board[i][j] == 'O') {
                    bfs(board, i, j);
                }
            }
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 'Y') board[i][j] = 'O';
            }
        }
    }

    private void bfs(char[][] board, int i, int j) {
        int row = board.length;
        int col = board[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        board[i][j] = 'Y';
        while (!queue.isEmpty()) {
                int[] pos = queue.poll();
                for (int[] dir : direction) {
                    int subsetI = pos[0] + dir[0];
                    int subsetJ = pos[1] + dir[1];

                    if (subsetI > 0 && subsetI < row && subsetJ > 0 && subsetJ < col && board[subsetI][subsetJ] == 'O') {
                        board[subsetI][subsetJ] = 'Y';
                        queue.offer(new int[]{subsetI, subsetJ});
                    }
                }
            }
        }
    }