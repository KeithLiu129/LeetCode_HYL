package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC542_01_Matrix {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return new int[][] {};
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dist = new int[rows][cols];
        Queue<int[]> q = new LinkedList<>();
        int[][] DIRS = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        int step = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] dir : DIRS) {
                    int ii = cur[0] + dir[0];
                    int jj = cur[1] + dir[1];
                    if (ii >= 0 && ii < rows && jj >= 0 && jj < cols && matrix[ii][jj] != 0 && dist[ii][jj] != 0) {
                        dist[ii][jj] = step;
                        q.offer(new int[] {ii, jj});
                    }

                }
            }
            step++;
        }

        return dist;
    }
}
