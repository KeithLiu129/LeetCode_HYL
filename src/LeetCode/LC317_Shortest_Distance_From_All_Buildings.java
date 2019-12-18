package LeetCode;

//317. Shortest Distance from All Buildings
//https://leetcode.com/problems/shortest-distance-from-all-buildings/

import java.util.LinkedList;
import java.util.Queue;

public class LC317_Shortest_Distance_From_All_Buildings {
    private int[][] Directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };
    public int shortestDistance(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return 0;

        int row = grid.length;
        int col = grid[0].length;
        int[][] sum = new int[row][col];
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, sum, i, j);
                }
            }
        }

        for (int i = 0; i < row; i++){
            for (int j = 0; j< col; j++) {
                if (grid[i][j] == 0) min = Math.min(min, sum[i][j]);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void bfs (int[][] grid, int[][] sum, int i, int j) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i * col + j);
        int minLen = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Integer cur = queue.poll();
                int curI = cur / col, curJ = cur % col;
                for (int[] dir : Directions) {
                    int ii = curI + dir[0];
                    int jj = curJ + dir[1];
                    if (ii >= 0 && ii < row && jj >= 0 && jj < col && grid[ii][jj] == 0 && !visited[ii][jj]) {
                        queue.offer(ii * col + jj);
                        visited[ii][jj] = true;
                        sum[ii][jj] += minLen;
                    }
                }
            }
            minLen ++;
        }

        //corner case
        for (int curI = 0; curI < row; curI++) {
            for (int curJ = 0; curJ < col; curJ++) {
                if (grid[curI][curJ] == 0 && !visited[curI][curJ]) {
                    grid[curI][curJ] = 3; //a number with no meanings
                }
            }
        }
    }

}
