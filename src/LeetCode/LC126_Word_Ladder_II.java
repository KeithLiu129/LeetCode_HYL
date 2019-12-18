package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC126_Word_Ladder_II {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (wordList == null || wordList.size() == 0) return res;
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }
        if (!dict.contains(endWord)) return res;
        if (beginWord.equals(endWord)) return res;
        HashSet<String> beginSet = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int step = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                HashSet<String> tmpSet = new HashSet<>();
                tmpSet = beginSet;
                beginSet = endSet;
                endSet = tmpSet;
            }
            HashSet<String> next = new HashSet<>();
            for (String word : beginSet) {
                List<String> cur = convert(word);
                for (String s : cur) {
                    if (endSet.contains(s)) res.add();
                    if (dict.contains(s)) {
                        dict.remove(s);
                        next.add(s);

                    }
                }
            }
            step++;
            beginSet = next;
        }

        return 0;
    }

    private List<String> convert(String str) {
        List<String> res = new ArrayList<>();
        char[] arr = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            char tmp = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != tmp) {
                    arr[i] = c;
                    String newStr = String.valueOf(arr);
                    res.add(newStr);
                }
            }
            arr[i] = tmp;
        }
        return res;
    }
}
