package LeetCode;

//96. Unique Binary Search Trees
//https://leetcode.com/problems/unique-binary-search-trees/

public class LC96_Unique_Binary_Search_Trees {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
