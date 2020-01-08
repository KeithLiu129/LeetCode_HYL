package LeetCode;

public class LC408_Valid_Word_Abbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        //c.c
        //c.c.
        int i = 0;
        int j = 0;
        char[] s=  word.toCharArray();
        char[] t = abbr.toCharArray();
        while (i < word.length() && j < abbr.length()) {
            if (Character.isDigit(t[j])) {
                if (t[j] == '0') return false;
                int val = 0;
                while (j < abbr.length() && Character.isDigit(t[j])) {
                    val = 10 * val + t[j] - '0';
                    j++;
                }
                i += val;

            }else {
                if (s[i++] != t[j++]) return false;
            }
        }
        return i == word.length() && j == abbr.length();
    }
}