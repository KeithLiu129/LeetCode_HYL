package LeetCode;

//93. Restore IP Addresses
//https://leetcode.com/problems/restore-ip-addresses/

import java.util.ArrayList;
import java.util.List;

public class LC93_Restore_Ip_Addresses {
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) return new ArrayList<>();

        List<String> res = new ArrayList<>();

        dfs(s, new ArrayList<>(), res, 0);
        return res;
    }

    private void dfs(String s, List<String> parts, List<String> res, int index) {
        if (parts.size() == 4 && index == s.length()) {
            res.add(toString(parts));
            return;
        }

        if (parts.size() == 4) return;

        for (int i = index; i < index + 3 && i < s.length(); i++) {
            String tmp = s.substring(index, i + 1);
            if (isValid(tmp)) {
                parts.add(tmp);
                dfs(s, parts, res, i + 1);
                //wall
                parts.remove(parts.size() - 1);
            }
        }
    }

    private String toString(List<String> parts) {
        StringBuilder sb = new StringBuilder();
        for (String str : parts) {
            sb.append(str + ".");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private boolean isValid(String s) {
        if(s == null || s.length() == 0 || s.length() > 3) return false;
        if (s.charAt(0) == '0') {
            return s.length() == 1 ? true : false;
        }
        Integer intValue = Integer.valueOf(s);
        return intValue >= 0 && intValue <= 255;
    }

}
