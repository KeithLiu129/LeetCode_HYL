package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC90_Subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(nums, res, new ArrayList<>(), visited, 0);
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, List<Integer> parts, boolean[] visited, int index) {
            res.add(new ArrayList<>(parts));

        for (int i = index; i < nums.length; i++) {
            if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;
            parts.add(nums[i]);
            visited[i] = true;
            dfs(nums, res, parts, visited, i + 1);
            //wall
            parts.remove(parts.size() - 1);
            visited[i] = false;
        }
    }
}
