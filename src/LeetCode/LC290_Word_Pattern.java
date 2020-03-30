package LeetCode;

import java.util.HashMap;

/**
 * ${Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.}
 *
 * @author KeithLiu on 2020-03-29
 */

public class LC290_Word_Pattern {
        public boolean wordPattern(String pattern, String str) {
            //c.c.
            if (pattern == null || str == null) return false;
            String[] arr = str.split(" ");
            if (arr.length != pattern.length()) return false;

            HashMap<Character, String> map = new HashMap<>();
            for(int i = 0; i < arr.length; i++) {
                char c = pattern.charAt(i);
                if (map.containsKey(c)) {
                    if (!map.get(c).equals(arr[i])) {
                        return false;
                    }
                }else {
                    if (map.containsValue(arr[i])) return false;
                    map.put(c, arr[i]);
                }
            }
            return true;
        }
    }
