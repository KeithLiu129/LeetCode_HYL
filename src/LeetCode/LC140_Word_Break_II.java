package LeetCode;

import java.util.*;

public class LC140_Word_Break_II {
    public List<String> wordBreak(String s, List<String> wordDict) {
        //c.c.
        List<String> res = new ArrayList<>();
        Set<String> dict = new HashSet<>();
        boolean[] m = new boolean[s.length() + 1];//看每一位往后是否能break
        Arrays.fill(m, true);
        for (String word : wordDict) {
            dict.add(word);
        }
        dfs(s, dict, res, new StringBuilder(), 0, m);
        return res;
    }

    private void dfs(String s, Set<String> dict, List<String> res, StringBuilder path, int level, boolean[] m) {
        if (level == s.length()) {
            res.add(path.toString());
            return;
        }
        int curSize = res.size();
        for (int i = level + 1; i <= s.length(); i++) {
            String tmp = s.substring(level, i);
            if (dict.contains(tmp) && m[level]) {
                    int pathLen = path.length();
                    if (pathLen == 0) {
                        path.append(tmp);
                    }else {
                        path.append(" " + tmp);
                    }
                    dfs(s, dict, res, path, i, m);
                    path.setLength(pathLen);
                }
            }
        if (curSize == res.size()) {
            m[level] = false;
        }

    }
}
