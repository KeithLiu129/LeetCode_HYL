package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LC301_Remove_Invalid_Parentheses {
    public List<String> removeInvalidParentheses(String s) {
        if (s == null || s.length() == 0) return new ArrayList<>();
        HashSet<String> res = new HashSet<>();
        int theta = 0;
        int rmL = 0, rmR = 0;

        char[] arr = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (arr[i] == '(') {
                rmL++;
            }
            if (arr[i] == ')'){
                if (rmL > 0) rmL--;
                else rmR++;
            }
        }
        dfs(s, res, new StringBuilder(), 0, 0, rmL, rmR);

        List<String> list = new ArrayList<>(res);
        return list;
    }

    private void dfs(String s, HashSet<String> res, StringBuilder path, int index, int theta, int rmL, int rmR) {
        if (index == s.length() && theta == 0 && rmL == 0 && rmR == 0) {
            res.add(path.toString());
            return;
        }
        if (theta < 0 || index >= s.length() || rmL < 0 || rmR < 0) {
            return;
        }
        char ch = s.charAt(index);
        if (ch == '(') {
            // remove
            dfs(s, res, path, index + 1, theta, rmL - 1, rmR);
            // keep
            path.append('(');
            dfs(s, res, path, index + 1, theta + 1,rmL, rmR);
            path.setLength(path.length() - 1);
        }else if (ch == ')') {
            //remove
            dfs(s, res, path, index + 1, theta, rmL, rmR - 1);
            //keep
            path.append(')');
            dfs(s, res, path, index + 1, theta - 1, rmL, rmR);
            path.setLength(path.length() - 1);
        }else {
            path.append(ch);
            dfs(s, res, path, index + 1, theta, rmL, rmR);
            //wall
            path.setLength(path.length() - 1);
        }
    }
}
