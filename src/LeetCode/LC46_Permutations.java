package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC46_Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        if(nums.length == 0 || nums == null) return res;

        ArrayList<Integer> output = new ArrayList<>();
        for (int num: nums) output.add(num);

        dfs(output, 0, res);

        return res;
    }

    private void dfs(ArrayList<Integer> output, int index, List<List<Integer>> res) {
        //base case
        if (index == output.size() - 1) {
            res.add(new ArrayList<Integer>(output)); //deep copy
            return;
        }

        for (int i = index; i < output.size(); i++) {
            Collections.swap(output, index, i);
            dfs(output, index + 1, res);
            //wall
            Collections.swap(output, index, i); //backtracking
        }
    }


}
