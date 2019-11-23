package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class LC288_Unique_Word_Abbreviation {
    private HashMap<String, String> map;
    public LC288_Unique_Word_Abbreviation(String[] dictionary) {
        map = new HashMap<>(dictionary.length);
        for (String word : dictionary) {
            String abbrWord = convert(word);
            if (map.containsKey(abbrWord)){
                if (!map.get(abbrWord).equals(word)) {
                    map.put(abbrWord, "");
                }
            }else {
                map.put(abbrWord, word);
            }
        }
    }

    public boolean isUnique(String word) {
        return !map.containsKey(convert(word)) || map.get(convert(word)).equals(word) ;
    }

    private String convert (String word) {
        int len = word.length();
        if (len <= 2) return word;

        return "" + word.charAt(0) + (len - 2) + word.charAt(len - 1);
    }
}
