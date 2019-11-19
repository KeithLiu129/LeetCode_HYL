package LeetCode;

import java.util.HashSet;

public class LC694_Number_Of_Distinct_Island {
    public int numDistinctIslands(int[][] grid) {
        //c.c.
        int row = grid.length;
        int col = grid[0].length;
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb,"o");
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }

    private void dfs(int[][] grid, int x, int y, StringBuilder sb, String s) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0) {
            return;
        }
        sb.append(s);
        grid[x][y] = 0;
        dfs(grid, x - 1, y, sb,"u"); // up
        dfs(grid, x + 1, y, sb,"d"); // down
        dfs(grid, x, y - 1, sb,"l"); // left
        dfs(grid, x, y + 1, sb,"r"); // right
        sb.append("b");
    }
}
