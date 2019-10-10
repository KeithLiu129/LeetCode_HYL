package LeetCode;

//39. Combination Sum
//https://leetcode.com/problems/combination-sum/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC39_Combination_Sum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if(candidates == null || candidates.length == 0) return result;

        dfs(candidates, target, 0, 0, result, new ArrayList<>());

        return result;
    }

    private void dfs(int[] nums, int target, int sum, int index, List<List<Integer>> result, List<Integer> list) {
        if(sum > target || index >= nums.length) return;

        if(sum == target) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(nums, target, sum + nums[i], i, result, list);
            //wall
            list.remove(list.size() - 1);
        }
    }
}
