package LeetCode;

public class LC115_DIstinct_Subsequences {
    public int numDistinct(String s, String t) {
        //cc
        if (t == null || s == null) return 0;

        int sLen = s.length();
        int tLen = t.length();
        int[][] dp = new int[sLen + 1][tLen + 1];
        // base case

        for (int i = 0; i < sLen; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= sLen; i++) {
            for (int j = 1; j <= tLen; j++){
                if (s.charAt(i - 1) != t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[sLen][tLen];
    }
}
