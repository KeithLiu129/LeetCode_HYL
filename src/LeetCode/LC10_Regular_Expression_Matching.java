package LeetCode;

//10. Regular Expression Matching
//https://leetcode.com/problems/regular-expression-matching/

public class  LC10_Regular_Expression_Matching {
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) return false;
        return dfs(s, p, 0, 0, new Boolean[s.length() + 1][p.length()]);
    }

    private boolean dfs(String s, String p, int idxS, int idxP, Boolean[][] mem) {
        int lenS = s.length();
        int lenP = p.length();
        if (mem[idxS][idxP] != null) return mem[idxS][idxP];
        if (idxP == lenP) {
            return idxS == lenS;
        }
        if (idxP == lenP - 1 || p.charAt(idxP + 1) != '*' ) {
              if (idxS < lenS && (p.charAt(idxP) == '.' || p.charAt(idxP) == s.charAt(idxS))) {
                   mem[idxS][idxP] = dfs(s, p, idxS + 1, idxP + 1, mem);
                   return mem[idxS][idxP];
              }else {
                  mem[idxS][idxP] = false;
                  return false;
              }

        }else {
            int i = idxS - 1;
            while (i < lenS && (i == idxS - 1 || p.charAt(idxP) == '.' || p.charAt(idxP) == s.charAt(i))) {
                if (dfs(s, p, i + 1, idxP + 2, mem)) {
                    mem[idxS][idxP] = true;
                    return mem[idxS][idxP];
                }
                i++;
            }
            mem[idxS][idxP] = false;
            return false;
        }

    }

}
