package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC296_Best_Meeting_Point {
    public int minTotalDistance(int[][] grid) {
        List<Integer> rows = collectRows(grid);
        List<Integer> cols = collectCols(grid);
        int row = rows.get(rows.size() / 2);
        int col = cols.get(cols.size() / 2);
        return findDistance(rows, row) + findDistance(cols, col);
    }

    private List<Integer> collectRows(int[][] grid) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) res.add(i);
            }
        }
        return res;
    }

    private List<Integer> collectCols(int[][] grid) {
        List<Integer> res = new ArrayList<>();
        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; j < grid.length; i++) {
                if (grid[i][j] == 1) res.add(j);
            }
        }
        return res;
    }

    private int findDistance(List<Integer> points, int ori) {
        int dis = 0;
        for (int point : points) {
            dis += Math.abs(point - ori);
        }
        return dis;
    }
}
