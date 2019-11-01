package LeetCode;

public class Find_Maximum_Of_Minimum_Of_Path {
    public int[][] dic = new int[][]{{0, 1}, {1, 0}}; // direction right and up

    public int findMax(int[][] maze, int[] start, int[] end) {
        //c.c.
        // if (maze == null || maze.length == 0 || maze[0].length == 0) throw

        int row = maze.length;
        int col = maze[0].length;
        int res = Integer.MIN_VALUE;
        boolean[][] isVisited = new boolean[row][col];

        return dfs(maze, start, end, row, col, isVisited, res);
    }

    private int dfs(int[][] maze, int[] start, int[] end, int row, int col, boolean[][] isVisited, int res) {
        int min = 0;

        //base case
        if (isVisited[start[0]][start[1]]) return 0;
        if (start[0] == end[0] && start[1] == end[1]) {
            res = Math.max(res, min);
        } //reach the destination

        isVisited[start[0]][start[1]] = true;

        for (int[] dir : dic) {
            int offSetI = start[0];
            int offSetJ = start[1];

            while (offSetI + dir[0] >= 0 && offSetI + dir[0] < row
                    && offSetJ + dir[1] >= 0 && offSetJ + dir[1] < col
                    && maze[offSetI + dir[0]][offSetJ + dir[1]] < res) {

                offSetI += dir[0];
                offSetJ += dir[1];
                min = Math.min(min, maze[offSetI][offSetJ]);
            }
        }

        return min;
    }


    public static void main(String[] args) {
        int[][] maze = {{1, 2, 3}, {4, 5, 1}};
        int[] start = {0, 0};
        int[] end = {1, 2};
        Find_Maximum_Of_Minimum_Of_Path sol = new Find_Maximum_Of_Minimum_Of_Path();
        int res = sol.findMax(maze, start, end);
        System.out.println(res);
    }
}
