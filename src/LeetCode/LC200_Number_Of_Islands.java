package LeetCode;

//200. Number of Islands
//https://leetcode.com/problems/number-of-islands/

import java.util.LinkedList;
import java.util.Queue;

public class LC200_Number_Of_Islands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }

        int count = 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                if (grid[i][j] == '1') {
                    visited[i][j] = true;
                    bfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfs(char[][] grid, int x, int y, boolean[][] visited) {
        int[][] Directions = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0], j = cur[1];
            for (int[] dir : Directions) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                if (ii >= 0 && ii < grid.length && jj >= 0 && jj < grid[0].length && visited[ii][jj] != true && grid[ii][jj] == '1') {
                    visited[ii][jj] = true;
                    bfs(grid, ii, jj, visited);
                }
            }
        }
    }
}
