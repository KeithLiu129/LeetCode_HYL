package testing;

import java.util.*;

class Solution {
        public static List<String> wordBreak(String s, List<String> wordDict) {
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < wordDict.size(); i++) {
                set.add(wordDict.get(i));
            }
            return wordBreakHelper(s, set, new HashMap<String, List<String>>());
        }

        private static List<String> wordBreakHelper(String s, HashSet<String> set, HashMap<String, List<String>> map) {
            if (s.length() == 0) {
                return new ArrayList<>();
            }
            if (map.containsKey(s)) {
                return map.get(s);
            }
            List<String> res = new ArrayList<>();
            for (int j = 0; j < s.length(); j++) {
                //判断当前字符串是否存在
                if (set.contains(s.substring(j, s.length()))) {
                    //空串的情况，直接加入
                    if (j == 0) {
                        res.add(s.substring(j, s.length()));
                    } else {
                        //递归得到剩余字符串的所有组成可能，然后和当前字符串分别用空格连起来加到结果中
                        List<String> temp = wordBreakHelper(s.substring(0, j), set, map);
                        for (int k = 0; k < temp.size(); k++) {
                            String t = temp.get(k);
                            res.add(t + " " + s.substring(j, s.length()));
                        }
                    }

                }
            }
            //缓存结果
            map.put(s, res);
            return res;
        }

    public static void main(String[] args) {
        List<String> dic = new ArrayList<>();
        dic.add("cd");
        dic.add("c");
        String s1 = "abcd";
        System.out.println(wordBreak(s1, dic));
    }
}



