package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class  LC320_Generalized_Abbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        if (word == null || word.length() == 0) return res;
        dfs(res, word, new StringBuilder(), 0, 0;
        return res;
    }

    private void dfs(List<String> res, String word, StringBuilder sb, int index, int prev) {
        if (index == word.length()) {
            if (prev > 0) {
                int len = sb.length();
                sb.append(prev);
                res.add(sb.toString());
                sb.setLength(len);
            } else {
                res.add(sb.toString());
            }
            return;
        }
        // regard this char as a number
        dfs (res, word, sb, index + 1, prev + 1);

        //keep the original char

        int len = sb.length();
        if (prev > 0) {
            sb.append(prev);
        }
        sb.append(word.charAt(index));
        dfs(res, word, sb, index + 1, 0);
        sb.setLength(len);
    }
}
