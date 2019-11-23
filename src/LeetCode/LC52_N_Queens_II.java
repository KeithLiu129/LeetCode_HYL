package LeetCode;

import java.util.HashSet;

public class LC52_N_Queens_II {
    public int totalNQueens(int n) {
        //c.c

        boolean[] cols = new boolean[n];
        boolean[] down = new boolean[2 * n];
        boolean[] up = new boolean[2 * n];
        return dfs(n, cols, down, up, 0, 0);
    }

    private int dfs(int n, boolean[] cols, boolean[] down, boolean[] up, int level, int count) {
        if (level == n) {
            count++;
        } else {
            for (int i = 0; i < n; i++) {
                if (cols[i] || down[i - level + n] || up[i + level]) {
                    continue;
                }
                cols[i] = true;
                down[i - level + n] = true;
                up[i + level] = true;
                count = dfs(n, cols, down, up, level + 1, count);
                //wall
                cols[i] = false;
                down[i - level + n] = false;
                up[i + level] = false;
            }
        }
        return count;
    }
}
