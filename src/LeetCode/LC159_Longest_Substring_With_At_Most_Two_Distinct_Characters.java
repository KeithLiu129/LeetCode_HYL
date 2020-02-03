package LeetCode;

import java.util.HashMap;

public class LC159_Longest_Substring_With_At_Most_Two_Distinct_Characters {
    public int lengthOfLongestSubstringTwoDistinct(String s){
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while (i < s.length() && j < s.length()) {
            char c = s.charAt(j);
            map.put(c, j);
            if (map.size() > 2) {
                int left = s.length();
                for (int idx : map.values()) {
                    left = Math.min (left, idx);
                }
                char start = s.charAt(left);
                map.remove(start);
                i = left + 1;
            }
            j++;
            max = Math.max(j - i, max);
        }
        return max;
    }
}
