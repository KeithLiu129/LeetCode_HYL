package LeetCode;

import java.util.Arrays;

public class LC785_Is_Graph_Bipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1 && dfs(graph, color, 0, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] color, int index, int node) {
        if (color[node] != -1) {
            return color[node] == index;
        }

        color[node] = index;
        for (int next : graph[node]) {
            if (!dfs(graph, color, 1 - index, next)) {
                return false;
            }
        }
        return true;
    }
}
