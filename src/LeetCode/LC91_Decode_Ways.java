package LeetCode;

//91. Decode Ways
//https://leetcode.com/problems/decode-ways/

public class LC91_Decode_Ways {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;

        int[] dp = new int[s.length() + 1];
        //base case
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= s.length(); i++) {
            dp[i] = 0;
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            int twoDigits = (s.charAt(i - 2) - '0') * 10 + s.charAt(i - 1) - '0';
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
