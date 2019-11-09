package LeetCode;

//132. Palindrome Partitioning II
//https://leetcode.com/problems/palindrome-partitioning-ii/

public class LC132_Palindrome_Partitioning_II {
    public int minCut(String s) {
           if (s == null || s.length() == 0) throw new IllegalArgumentException();

           int len = s.length();
           boolean[][] isValid = new boolean[len][len];
           int[] dp = new int[len];


           for (int i = 0; i < len; i++) {
               dp[i] = i;
               for (int j = 0; j <= i; j++) {
                   if (s.charAt(j) == s.charAt(i) && (j + 1 >= i - 1 || isValid[j + 1][i - 1])) {
                       isValid[j][i] = true;
                       dp[i] = j == 0 ? 0 : Math.min(dp[i], dp[j - 1] + 1);
                   }
                }
           }
           return dp[len - 1];
    }
}
