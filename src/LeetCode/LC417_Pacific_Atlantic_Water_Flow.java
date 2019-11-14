package LeetCode;

import java.util.*;

import static java.util.Arrays.asList;

public class LC417_Pacific_Atlantic_Water_Flow {
    private int[][] Directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) return new ArrayList<>();

        int row = matrix.length, col = matrix[0].length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] Paci = new boolean[row][col];
        boolean[][] Atl = new boolean[row][col];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < row; i++) {
            Paci[i][0] = true;
            queue.add(col * i);
        }
        for (int i = 1; i < col; i++) {
            Paci[0][i] = true;
            queue.add(i);
        }

        bfs(matrix, Paci, Atl, res, queue);

        for (int i = 0; i < row; i++) {
            Atl[i][col - 1] = true;
            queue.add(col * i + col - 1);
        }
        for (int i = 0; i < col - 1; i++) {
            Atl[row - 1][i] = true;
            queue.add((row - 1) * col + i);
        }

        bfs(matrix, Atl, Paci, res, queue);

        return res;
    }

    private void bfs(int[][] matrix, boolean[][] self, boolean[][] other, List<List<Integer>> res, Queue<Integer> queue) {
        int col = matrix[0].length;
        int row = matrix.length;
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            int i = cur / col, j = cur % col;
            if (other[i][j]) {
                res.add(Arrays.asList(i, j));
            }
            for (int[] dir : Directions) {
                int ii = i + dir[0];
                int jj = j + dir[1];
                if (ii >= 0 && ii < row && jj >= 0 && jj < col && !self[ii][jj] && matrix[ii][jj] >= matrix[i][j]) {
                    queue.offer(ii * col + jj);
                    self[ii][jj] = true;
                }
            }
        }
    }
}
