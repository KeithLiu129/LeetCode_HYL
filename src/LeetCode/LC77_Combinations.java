package LeetCode;

//77. Combinations
//https://leetcode.com/problems/combinations/

import java.util.ArrayList;
import java.util.List;

public class LC77_Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if(n <= 0 || k > n) return result;

        dfs(n, k, 1, new ArrayList<>(), result);

        return result;
    }

    private void dfs(int n, int k, int level, List<Integer> list, List<List<Integer>> result) {
        if(list.size() >= k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = level; i <= n; i++) {
            list.add(i);
            dfs(n, k, i + 1, list, result);
            //wall
            list.remove(list.size() - 1);
        }
    }
}
