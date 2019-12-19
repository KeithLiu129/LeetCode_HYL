package LeetCode;

import java.util.*;

public class LC752_Open_the_Lock {
    public int openLock(String[] deadends, String target) {
        //c.c
        HashSet<String> dict = new HashSet<>();
        for (String s : deadends) {
            dict.add(s);
        }
        HashSet<String> visited = new HashSet<>();

        if (dict.contains(target) || dict.contains("0000")) return -1;
        String start = "0000";
        if (start.equals(target)) return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(start);
        visited.add(start);
        int step = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                List<String> list = convert(cur, dict, visited);
                for (String s : list) {
                    if (s.equals(target)) return step + 1;
                    visited.add(s);
                    q.offer(s);
                }
            }
            step++;
        }

        return -1;
    }

    private List<String> convert(String s, HashSet<String> set, HashSet<String> visited) {
        List<String> res = new ArrayList<>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char tmp = arr[i];
            if (tmp == '9') {
                arr[i] = '0';
            } else {
                arr[i] = (char)(tmp + 1);
            }
            String str = new String(arr);
            if (!set.contains(str) && !visited.contains(str)) {
                res.add(str);
            }

            if (tmp == '0') {
                arr[i] = '9';
            } else {
                arr[i] = (char)(tmp - 1);
            }
            String str1 = new String(arr);
            if (!set.contains(str1) && !visited.contains(str1)) {
                res.add(str1);
            }

            arr[i] = tmp;
        }
        return res;
    }
}
