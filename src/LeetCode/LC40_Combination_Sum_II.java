package LeetCode;

//40. Combination Sum II
//https://leetcode.com/problems/combination-sum-ii/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LC40_Combination_Sum_II {
    public List<List<Integer>> combinationSum2(int[] candidates, int target)  {
        List<List<Integer>> result = new ArrayList<>();

        if (candidates == null || candidates.length == 0) return result;

        Arrays.sort(candidates);
        dfs(candidates, target, 0, result, new ArrayList<>());

        return result;
    }

    private void dfs(int[] nums, int target, int index, List<List<Integer>> result, List<Integer> list) {
        if(target < 0) return;

        if(target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            dfs(nums, target - nums[i], i + 1, result, list);
            //wall
            list.remove(list.size() - 1);
        }
    }
}
