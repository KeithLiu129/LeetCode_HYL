package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC291_Word_Pattern_II {
    public boolean wordPatternMatch(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<String>();
        return dfs(pattern, str, map, 0, 0, set);
    }

    private boolean dfs(String p, String s, HashMap<Character, String> map, int idxP, int idxS, Set<String> set) {
        int lenP = p.length();
        int lenS = s.length();
        if (idxP == lenP) {
            return idxS == lenS;
        }
        Character ch = p.charAt(idxP);
        if (map.containsKey(ch)) {
            String tmp = map.get(ch);
            int tmpLen = tmp.length();
            if (idxS + tmpLen <= lenS && tmp.equals(s.substring(idxS, idxS + tmpLen))) {
                return dfs(p, s, map, idxP + 1, idxS + tmpLen, set);
            }else {
                return false;
            }
        }else {
            int maxL = maxLength(p, idxP, s, idxS, map);
            if (maxL < 1) return false;
            for (int i = 1; i <= maxL; i++) {
                String cur = s.substring(idxS, idxS + i);
                if (set.contains(cur)) continue;
                map.put(ch, cur);
                set.add(cur);
                if (dfs(p, s, map, idxP + 1, idxS + cur.length(), set)) {
                    return true;
                }
                map.remove(ch);
                set.remove(cur);
            }
        }
        return false;
    }
    private int maxLength(String p, int idxP, String s, int idxS, HashMap<Character, String> map) {
        int lenP = p.length();
        int lenS = s.length();
        int leftLen = lenS - idxS;
        int count = 1;
        Character c = p.charAt(idxP);
        for (int i = idxP + 1; i < lenP; i++) {
            Character cur = p.charAt(i);
            if (c == cur) count++;
            else {
                leftLen -= map.containsKey(cur) ? map.get(cur).length() : 1;
            }
        }
        return (int)leftLen / count;
    }
}
