package LeetCode;

import java.util.*;

public class LC127_Word_Ladder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //c.c.
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
                        if (next.equals(beginWord)) return minLen + 1;
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
