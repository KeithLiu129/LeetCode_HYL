package LeetCode;

//310. Minimum Height Trees
//https://leetcode.com/problems/minimum-height-trees/

import java.util.*;

public class LC310_Minimum_Height_Trees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        //corner case
        if (n == 0) return new ArrayList<>();
        if (n == 1) return Arrays.asList(0);

        List<Set<Integer>> tree = new ArrayList<>(n);
        for (int i = 0; i < n; i++) tree.add(new HashSet<>());
        for (int[] edge: edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (tree.get(i).size() == 1) leaves.add(i);
        }

        while (n > 2) {
            //delete the leaves
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();

            for (Integer i : leaves) {
                int j = tree.get(i).iterator().next(); //find the neighbours of leaves i
                tree.get(j).remove(i);

                if (tree.get(j).size() == 1) newLeaves.add(j);
            }

            leaves = newLeaves;
        }

        return leaves;
    }
}
