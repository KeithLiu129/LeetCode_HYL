package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC47_Permutations_II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, res, new ArrayList<>(), visited);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> path, boolean[] visited) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;

            path.add(nums[i]);
            visited[i] = true;
            dfs(nums, res, path, visited);
            visited[i] = false;
            path.remove(path.size() - 1);
        }
    }

}
