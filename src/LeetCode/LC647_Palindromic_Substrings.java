package LeetCode;

public class LC647_Palindromic_Substrings {
    public int countSubstrings(String s) {
        //c.c.
        int n = s.length();
        int count = n;
        int[][] dp = new int[n][n]; //dp[j][i] stand for the substring from index i to index j, is or not a palindrome

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                dp[j][i] = (s.charAt(i) == s.charAt(j) && i - j <= 2 || dp[j + 1][i - 1] == 1) ? 1 : 0;
                count += dp[j][i];
            }
        }
     return count;
    }

    public static void main(String[] args) {
        String s = "abc";
        LC647_Palindromic_Substrings sol = new LC647_Palindromic_Substrings();
        System.out.println(sol.countSubstrings(s));
    }
}
