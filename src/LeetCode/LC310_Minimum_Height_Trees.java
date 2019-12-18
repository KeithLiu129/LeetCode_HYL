package LeetCode;

//310. Minimum Height Trees
//https://leetcode.com/problems/minimum-height-trees/

import java.util.*;

public class LC310_Minimum_Height_Trees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //corner case
        if (edges == null || edges.length == 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();

        int[] indegree = new int[n];
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(i, new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            indegree[edges[i][0]]++;
            indegree[edges[i][1]]++;
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                q.offer(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            count += size;
            for (int i = 0; i < size; i++) {
                Integer id = q.poll();
                indegree[id]--;
                if (count == n) res.add(id);

                for (Integer adjId : map.get(id)) {
                    if (indegree[adjId] != 0) {
                        indegree[adjId]--;
                        if (indegree[adjId] == 1) {
                            q.offer(adjId);
                        }
                    }
                }
            }
        }

        return res;
    }
}
