package LeetCode;

//93. Restore IP Addresses
//https://leetcode.com/problems/restore-ip-addresses/

import java.util.ArrayList;
import java.util.List;

public class LC93_Restore_Ip_Addresses {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0 || s.length() > 12) return res;
        dfs(res, s, new StringBuilder(), 0, 0);
        return res;
    }

    private void dfs(List<String> res, String s, StringBuilder sb, int index, int count) {
        if (count == 4) {
            if (index == s.length()) {
                sb.setLength(sb.length() - 1);
                res.add(sb.toString());
            }
            return;
        }
        int length = sb.length();
        for (int i = 1; i <= 3; i++) {
            if (index + i > s.length()) break;

            int val = Integer.valueOf(s.substring(index, index + i));

            if (val <= 255) {
                sb.append(val + ".");
                dfs (res, s, sb, index + i, count + 1);
                //wall
                sb.setLength(length);
            }

            if (val == 0) {
                break;
            }
        }
    }
}