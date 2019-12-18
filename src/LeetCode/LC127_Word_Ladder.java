package LeetCode;

import java.util.*;

public class LC127_Word_Ladder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //c.c.
        /*
        if (beginWord == null || endWord == null || wordList == null || wordList.size() == 0) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        for (String str : wordList) {
            set.add(str);
        }
        int minLen = 1;

        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                List<String> nexts = convert(cur); //TODO
                for (String next : nexts) {
                    if (set.contains(next)) {
                        if (next.equals(endWord)) return minLen + 1;
                        queue.offer(next);
                        set.remove(next);
                    }
                }
            }
            minLen++;
        }
        return -1;
    }

    private List<String> convert(String s) {
        List<String> res = new ArrayList<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char tmp = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c != tmp) {
                    arr[i] = c;
                    String str = String.valueOf(arr);
                    res.add(str);
                }
            }
            arr[i] = tmp;
            }
        return res;
        }
    }
*/
        if (wordList == null || wordList.size() == 0) return -1;
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }
        if (!dict.contains(endWord)) return 0;
        if (beginWord.equals(endWord)) return 0;
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
                    if (endSet.contains(s)) return step + 1;
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
