package LeetCode;

//139. Word Break
//https://leetcode.com/problems/word-break/

import java.util.Arrays;
import java.util.List;

public class LC139_Word_Break {
    public boolean wordBreak(String s, List<String> wordDict) {
        //c.c.
        boolean[] isValid = new boolean[s.length()];
        Arrays.fill(isValid, true);
        return wordBreak(s, wordDict, isValid, 0);
    }

    private boolean wordBreak(String s, List<String> wordDict, boolean[] isValid, int index) {
        if (index == s.length()) return true;

        if (isValid[index]) return false;

        for (String str : wordDict) {
            if (s.startsWith(str, index))
                return wordBreak(s, wordDict, isValid, index + str.length());
        }

        isValid[index] = false;
        return false;
    }
}
