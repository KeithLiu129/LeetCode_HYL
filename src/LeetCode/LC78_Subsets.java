package LeetCode;

//78. Subsets
//https://leetcode.com/problems/subsets/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC78_Subsets {
    public List<List<Integer>> subsets(int[] nums){
           List<List<Integer>> result = new LinkedList<>();

           if (nums == null || nums.length == 0) return result;

           result.add(new ArrayList<>());
           dfs(result, nums, 0, new ArrayList<>());
           return result;
    }

    private void dfs(List<List<Integer>> result, int[] nums, int level, List<Integer> list) {
        if(level == nums.length) return;

        for(int i = level; i < nums.length; i++) {
            list.add(nums[i]);
            result.add(new ArrayList<>(list)); //deep copy the list
            dfs(result, nums, i + 1, list);
            //wall
            list.remove(list.size() - 1);
        }

        return;
    }
}
