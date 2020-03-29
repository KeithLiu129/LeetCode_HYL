package LeetCode;

import java.util.*;

public class LC126_Word_Ladder_II {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<List<String>> res = new ArrayList<>();
            //c.c.
            HashSet<String> dict = new HashSet<>();
            HashMap<String, List<String>> graph = new HashMap<>();

            for (String word : wordList) {
                dict.add(word);
            }
            if (!dict.contains(endWord)) {
                return res;
            }
            Queue<String> q = new LinkedList<>();
            q.offer(beginWord);
            boolean isFound = false;
            while (!q.isEmpty()) {
                int size = q.size();
                HashSet<String> levelVisited = new HashSet<>();
                for(int i = 0; i < size; i++) {
                    String cur = q.poll();
                    List<String> nexts = convert(cur);
                    for (String s : nexts) {
                        if (s.equals(endWord)) isFound = true;
                        if (dict.contains(s)) {
                            if (!levelVisited.contains(s)) {
                                List<String> one = new ArrayList<>();
                                one.add(cur);
                                graph.put(s, one);
                                q.offer(s);
                                levelVisited.add(s);
                            }else {
                                List<String> one = graph.get(s);
                                one.add(cur);
                                graph.put(s, one);
                            }
                        }
                    }
                }
                dict.removeAll(levelVisited);
                if(isFound) {
                    List<String> one = new LinkedList<>(); //cha tou
                    one.add(endWord);
                    dfs(one, endWord, beginWord, graph, res);
                    return res;  ////important!!!!!!!!!
                }
            }

            return res;
        }


        private List<String> convert(String s) {
            List<String> res = new ArrayList<>();
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                char cur = arr[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c != cur) {
                        arr[i] = c;
                        String tmp = String.valueOf(arr);
                        res.add(tmp);
                    }
                }
                arr[i] = cur;
            }
            return res;
        }

        private void dfs(List<String> one, String begin, String end, HashMap<String, List<String>> graph, List<List<String>> res) {
            // from end to start
            // base case
            if (begin.equals(end)) {
                res.add(new LinkedList<>(one)); //deep copy
                return;
            }
            List<String> cur =  graph.get(begin);
            for (String s : cur) {
                one.add(0, s);
                dfs(one, s, end, graph, res);
                //wall
                one.remove(0);
            }
        }
    }
