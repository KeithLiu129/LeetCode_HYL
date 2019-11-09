package LeetCode;

//213. House Robber II
//https://leetcode.com/problems/house-robber-ii/

public class LC213_House_Robber_II {
    public int rob(int[] nums) {
        //c.c
        int len = nums.length;
        if (nums == null || len == 0) return 0;
        if (len == 1)  return nums[0];
        if (len == 2) return nums[0] >= nums[1] ? nums[0] : nums[1];

        return Math.max(rob(nums, 0, len - 2), rob(nums, 1, len - 1));
    }

    private int rob(int[] nums, int st, int ed) {
        int n = ed - st + 1;
        int[] dp = new int[n + 1];

        dp[1] = nums[st];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[st + i - 1], dp[i - 1]);
        }
        return dp[n];
    }
}
