package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC131_Palindrome_Partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;

        boolean[][] isPalidrome = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j))
                isPalidrome[j][i] = i - j <= 2 || isPalidrome[j + 1][i - 1];
            }
        }

        List<String> part = new ArrayList<>();
        dfs(res, part, isPalidrome, 0, s);
        return res;
    }

    private void dfs(List<List<String>> res, List<String> part, boolean[][] isPalidrome, int index, String s) {
        if (index == s.length()) {
            res.add(new ArrayList<>(part));
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalidrome[index][i]) {
                part.add(s.substring(index, i + 1));
                dfs(res, part, isPalidrome, i + 1, s);
                //wall
                part.remove(part.size() - 1);
            }
        }
    }
}
