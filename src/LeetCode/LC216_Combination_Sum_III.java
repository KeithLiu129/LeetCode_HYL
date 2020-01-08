package LeetCode;

//216. Combination Sum III
//https://leetcode.com/problems/combination-sum-iii/

import java.util.ArrayList;
import java.util.List;

public class LC216_Combination_Sum_III {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();

        if (k > n || n <= 0) return result;

        dfs(k, n, 1, result, new ArrayList<>());

        return result;
    }

    private void dfs(int k, int n, int index, List<List<Integer>> result, List<Integer> list) {
        if(list.size() == k && n == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        if(n < 0 || list.size() > k) return;

        for(int i = index; i <= 9; i++) {
            list.add(i);
            dfs(k, n - i, i + 1, result, list);
            //wall
            list.remove(list.size() - 1);
        }
    }
}
