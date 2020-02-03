package LeetCode;

public class LC1143_Longest_Common_Subsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        //dp[i][j] represents the longest common subsequence of first i letter from string1, j letter from string 2, not must including ith and jth letter.
        // dp[i][j] = dp[i - 1][j - 1], if Str1[i] == Str2[j],
        //otherwise, dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);

        if(text1 == null || text1.length() == 0 || text2 == null || text2.length() == 0) return 0;
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }


        return dp[m][n];
    }
}
