package LeetCode;

//286. Walls and Gates
//https://leetcode.com/problems/walls-and-gates/

import java.util.LinkedList;
import java.util.Queue;

public class LC286_Walls_And_Gates {
        private static final int EMPTY = Integer.MAX_VALUE;
        private static final int GATE = 0;
        private static final int[][] DIRECTIONS = {
                {1, 0},   //up
                {-1, 0},   //down
                {0, -1},   //left
                {0, 1}    //right
        };

        public void wallsAndGates(int[][] rooms) {
            if (rooms == null || rooms.length == 0 || rooms[0] == null || rooms[0].length == 0) throw new IllegalArgumentException();

            int row = rooms.length, col = rooms[0].length;

            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (rooms[i][j] == 0)
                        queue.offer(col * i + j);
                }
            }

            int minDist = 1;

            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    int cur = queue.poll();
                    int i = cur / col, j = cur % col;

                    for (int[] dir : DIRECTIONS) {
                        int offsetI = i + dir[0];
                        int offsetJ = j + dir[1];

                        if (offsetI >= 0 && offsetI < row
                                && offsetJ >= 0 && offsetJ < col
                                && rooms[offsetI][offsetJ] == EMPTY) {
                                queue.offer(offsetI * col + offsetJ);
                                rooms[offsetI][offsetJ] = minDist;
                        }
                    }
                }
                minDist++;
            }
        }
}
