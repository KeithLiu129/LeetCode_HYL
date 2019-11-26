package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC17_Letter_Combination_Of_A_Phone_Number {
    private final String[] numsToChar = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public List<String> letterCombinations(String digits){
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        dfs(digits, res, new StringBuilder(), 0);
        return res;
    }

    private void dfs (String s, List<String> res, StringBuilder path, int level) {
        if (path.length() == s.length()) {
            res.add(path.toString());//hard copy
            return;
        }

        char ch = s.charAt(level);
        String tmp = numsToChar[ch - '0'];
        for (int i = 0; i < tmp.length(); i++) {
            path.append(tmp.charAt(i));
            dfs(s, res, path, level + 1);
            //wall
            path.setLength(path.length() - 1);
        }
    }
}
