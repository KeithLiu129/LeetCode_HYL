package LeetCode;

import java.util.Arrays;

/**
 * ${Given an array of integers nums and a positive integer k, find whether it's possible to divide this array into k non-empty subsets whose sums are all equal.}
 *
 * @author KeithLiu on 2020-03-29
 */

public class LC698_Partition_to_K_Equal_Sum_Subset {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            if (k > nums.length) return false;
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }
            if (sum % k != 0) return false;
            boolean[] visited = new boolean[nums.length];
            Arrays.sort(nums);
            return dfs(nums, 0, nums.length - 1, visited, sum / k, k);
        }

        public boolean dfs(int[] nums, int sum, int st, boolean[] visited, int target, int round) {
            if (round == 0) return true;
            if (sum == target && dfs(nums, 0, nums.length - 1, visited, target, round - 1)) return true;
            for (int i = st; i >= 0; i--) {
                if (!visited[i] && sum + nums[i] <= target) {
                    visited[i] = true;
                    if (dfs(nums, sum + nums[i], i - 1, visited, target, round)) return true;
                    visited[i] = false;
                }
            }
            return false;
        }
}
