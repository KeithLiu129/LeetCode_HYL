package LeetCode;

//22. Generate Parentheses
//https://leetcode.com/problems/generate-parentheses/submissions/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC22_Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if(n <= 0) return result;

        dfs(result, n, n, new StringBuilder());

        return result;

    }
    private void dfs(List<String> result, int left, int right, StringBuilder sb) {
        if(left == 0 & right == 0) {
            result.add(sb.toString());
            return;
        }

        if(left > right) return;

        if(left > 0) {
            sb.append('(');
            dfs(result,left - 1, right, sb);
            //wall
            sb.deleteCharAt(sb.length() - 1);
        }

        if(right > 0 && right > left) {
            sb.append(')');
            dfs(result, left, right - 1, sb);
            //wall
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
