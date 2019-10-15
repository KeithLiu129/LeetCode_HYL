package LeetCode;

//438. Find All Anagrams in a String
//https://leetcode.com/problems/find-all-anagrams-in-a-string/

import java.util.LinkedList;
import java.util.List;

public class LC438_Find_All_Anagrams_In_A_String {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new LinkedList<>();

        if(s == null || s.length() == 0 || p == null || p.length() > s.length()) return res;

        int pLen = p.length();
        int sLen = s.length();

        for (int i = 0; i <= sLen - pLen; i++) {
            String tmp = s.substring(i, i + pLen); // substring[begin, end)
            if (isAnagram(tmp, p)) {
                res.add(i);
            }
        }

        return res;

    }

    private boolean isAnagram(String s, String p) {
        if(s.length() != p.length()) return false;

        int[] pattern = new int[26];

        for (char i : s.toCharArray()) {
            pattern[i - 'a']++;
        }

        for (char i : p.toCharArray()) {
            pattern[i - 'a']--;
        }

        for (int i : pattern) {
            if (i != 0) return false;
        }

        return true;



    }

}
