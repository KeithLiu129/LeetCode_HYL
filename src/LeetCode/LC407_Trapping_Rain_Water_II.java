package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC407_Trapping_Rain_Water_II {
    class Cell {
        int x;
        int y;
        int height;
        public Cell(int i, int j, int val) {
            this.x = i;
            this.y = j;
            this.height = val;
        }
    }
    public int trapRainWater(int[][] heightMap) {
        //step1: start from the border, enqueue them into a priority queue ordered by their height
        //step2: poll out the smallest one from pq, start from them, do bfs for its adjencency
        //step3: calculate the water it may has then add to res,update its height, then push em into the pq
        //step4: keep doing 1,2,3, until we have 0 element in the queue;
        if (heightMap == null || heightMap.length == 0 || heightMap[0] == null || heightMap[0].length == 0) return 0;
        int rows = heightMap.length;
        int cols = heightMap[0].length;
        PriorityQueue<Cell> pq = new PriorityQueue<>(rows * cols, new Comparator<Cell>() {
            @Override
            public int compare(Cell c1, Cell c2) {
                return  c1.height - c2.height;
            }
        });

        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            pq.offer(new Cell(i, 0, heightMap[i][0]));
            pq.offer(new Cell(i, cols - 1, heightMap[i][cols - 1]));
            visited[i][0] = true;
            visited[i][cols - 1] = true;
        }
        for (int j = 1; j < cols - 1; j++) {
            pq.offer(new Cell(0, j, heightMap[0][j]));
            pq.offer(new Cell(rows - 1, j, heightMap[rows - 1][j]));
            visited[0][j] = true;
            visited[rows - 1][j] = true;
        }

        int res = 0 ;
        int[][] DIRS = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };
        while (!pq.isEmpty()) {
            Cell cur = pq.poll();
            int height = cur.height;
            for (int[] dir : DIRS) {
                int ii = cur.x + dir[0];
                int jj = cur.y + dir[1];
                if (ii >= 0 && ii < rows && jj >= 0 && jj < cols && !visited[ii][jj]) {
                    res += Math.max(0, height - heightMap[ii][jj]);
                    pq.offer(new Cell(ii, jj, Math.max(height, heightMap[ii][jj])));
                    visited[ii][jj] = true;
                }
            }
        }

        return res;
    }
}
