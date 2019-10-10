package LeetCode;

//378. Kth Smallest Element in a Sorted Matrix
//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC378_Kth_Smallest_Element_IN_A_Sorted_Matrix {
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix[0] == null || matrix.length == 0 || matrix[0].length == 0) return Integer.MAX_VALUE;

        int row = matrix.length;
        int col = matrix[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return matrix[o1[0]][o1[1]] - matrix[o2[0]][o2[1]];
            }
        });

        boolean[][] visited = new boolean[row][col];

        pq.offer(new int[]{0, 0});
        int result = 0;

        while (k-- > 0) {
            int[] cur = pq.poll();
            int curRow = cur[0];
            int curCol = cur[1];
            result = matrix[curRow][curCol];

            if (isValid(curRow + 1, curCol, row, col, visited)) {
                pq.offer(new int[]{curRow + 1, curCol});
                visited[curRow + 1][curCol] = true;
            }

            if (isValid(curRow, curCol + 1, row, col, visited)) {
               pq.offer(new int[]{curRow, curCol + 1});
               visited[curRow][curCol + 1] = true;
            }
        }

        return result;

    }

    private boolean isValid(int i, int j, int row, int col, boolean[][] visited) {
        return (i >= 0 && i < row && j >= 0 && j < col && !visited[i][j]);
    }
}
