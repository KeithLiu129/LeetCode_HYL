package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC282_Expression_Add_Operators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        //c.c
        dfs(num, target, res, new StringBuilder(), 0, 0, 0);
        return res;
    }

    private void dfs(String num, int target, List<String> res, StringBuilder sb, int index, long sum, long prev) {
        if (index == num.length()) {
            if (target == sum) {
                res.add(sb.toString());
            }
            return;
        }

        int len = sb.length();
        long val = 0;

        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(i) == '0') break; //大于1位的数不能以0开头
            long cur = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                sb.append(cur);
                dfs(num, target, res, sb, i + 1, sum + cur, cur);
            } else {
                sb.append('+');
                dfs(num, target, res, sb, i + 1, sum + cur, cur);
                sb.append('-');
                dfs(num, target, res, sb, i + 1, sum - cur, -cur);
                sb.append('*');
                dfs(num, target, res, sb, i + 1, (sum - prev) + cur * prev, cur * prev);
            }
            sb.setLength(len);
        }
    }
}
