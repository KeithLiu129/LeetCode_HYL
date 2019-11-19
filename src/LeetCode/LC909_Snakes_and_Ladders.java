package LeetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC909_Snakes_and_Ladders {
    public int snakesAndLadders(int[][] board) {
        //c.c
        int step = 0;
        int len = board.length;
        int[] flatten = convert(board);
        int target = len * len - 1;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[len * len];
        int start = flatten[0] == -1 ? 0 : flatten[0] - 1;
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == target) return step;
                int upper = Math.min(target, cur + 6);
                for (int j = cur + 1; j <= upper; j++) {
                    int dest = flatten[j] == -1 ? j : flatten[j] - 1;
                    if (visited[dest]) continue;
                    queue.offer(dest);
                    visited[dest] = true;
                }
            }
            step++;
        }
        return -1;
    }
    private int[] convert(int[][] grid) {
        int len = grid.length;
        int[] res = new int[len * len];
        int idx = 0;
        boolean leftToRight = true;
        for (int i = len - 1; i >= 0; i--){
            for (int j = 0; j < len; j++) {
                if (leftToRight) {
                    res[idx++] = grid[i][j];
                } else {
                    res[idx++] = grid[i][len - 1 - j];
                }

            }
            leftToRight = !leftToRight;
        }
        return res;
    }
}
