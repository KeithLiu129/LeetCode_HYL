package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC131_Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;

        int len = s.length();
        boolean[][] isPal = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            isPal[i][i] = true;
            for (int j = i; j >= 0; j--) {
                if (s.charAt(j) == s.charAt(i) && (j + 1 == i || isPal[j + 1][i - 1])) {
                    isPal[i][j] = true;
                }
            }
        }
        dfs (s, res, new ArrayList<String>(), 0, isPal);
        return res;
    }

    private void dfs(String s, List<List<String>> res, List<String> ans, int index, boolean[][] isPal) {
        int len = s.length();

        if (index == len) {
            List<String> temp = new ArrayList<>(ans);
            res.add(temp);
            return;
        }

        for (int i = index; i < len; i++) {
            if (isPal[index][i]) {
                String str = s.substring(index, i + 1);
                ans.add(str);
                dfs(s, res, ans, index + 1, isPal);
                ans.remove (ans.size() - 1);
            }
        }
    }
}
