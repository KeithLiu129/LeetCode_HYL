package LeetCode;

public class LC97_Interleaving_String {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];

        //base case
        dp[0][0] = true;

        for (int i = 1; i <= len1; i++) {

            dp[i][0] = s3.charAt(i - 1) == s1.charAt(i - 1);
        }

        for (int j = 1; j <= len2; j++) {

            dp[0][j] = s3.charAt(j - 1) == s2.charAt(j - 1);
        }

        //dp function
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int idxS1 = i - 1;
                int idxS2 = j - 1;
                int idxS3 = i + j - 1;

                if (s1.charAt(idxS1) == s3.charAt(idxS3)) {
                    dp[i][j] = dp[i - 1][j];
                }
                if (s2.charAt(idxS2) == s3.charAt(idxS3)) {
                    dp[i][j] = dp[i][j] || dp[i][j - 1];
                }
            }
        }
        return dp[len1][len2];
    }
}
