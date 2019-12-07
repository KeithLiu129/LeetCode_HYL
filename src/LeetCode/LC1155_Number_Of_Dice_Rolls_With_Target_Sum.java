package LeetCode;

public class LC1155_Number_Of_Dice_Rolls_With_Target_Sum {
    public int numRollsToTarget(int d, int f, int target) {
        if (target > d * f) return 0;

        int mod = 1000000007;
        int[][] dp = new int[d + 1][target + 1];
        dp[0][0] = 0;

        for (int i = 1; i <= d; i++) {
            for (int j = 1; j <= target; j++){
                for (int k = 1; k <= f && j - k >= 0; k++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % mod;
                }
            }
        }

        return dp[d][target];
    }
}
