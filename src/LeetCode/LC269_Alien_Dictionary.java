package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC269_Alien_Dictionary {
        private class V {
            char val;
            Status status;
            List<V> nexts;
            public V(char val){
                this.val = val;
                status = Status.Init;
                nexts = new ArrayList<>();
            }
        }

        enum Status {
            Init, Visiting, Visited;
        }
        int curLab;
        public String alienOrder(String[] words) {
            //step1 create vertex class V
            //step2 loop the input, build graph based on comparion
            //step3 for each vertex in the graph, do dfs to check if there exist cycle
            if (words.length == 1) {
                return words[0];
            }

            V[] graph = new V[26];
            List<V> vs = new ArrayList<>();
            String prev = words[0];
            for (int i = 1; i < words.length; i++) {
                String cur = words[i];
                int idx1 = 0;
                int idx2 = 0;
                boolean isValid = false;
                while (idx1 < prev.length() && idx2 < cur.length()) {
                    char ch1 = prev.charAt(idx1++);
                    char ch2 = cur.charAt(idx2++);
                    addVertex(graph, ch1, vs);
                    addVertex(graph, ch2, vs);

                    if (ch1 != ch2) {
                        //find one edge from ch1 to ch2
                        isValid = true;
                        graph[ch1 - 'a'].nexts.add(graph[ch2 - 'a']);
                        break;
                    }
                }

                while (idx1 < prev.length()){
                    if(!isValid) {
                        return ""; //couldnt find valid solution
                    }
                    char c = prev.charAt(idx1++);
                    addVertex(graph, c, vs);


                }

                while (idx2 < cur.length()) {
                    char c = cur.charAt(idx2++);
                    addVertex(graph, c, vs);
                }

                prev = cur;
            }
            char[] res = new char[vs.size()];
            curLab = vs.size() - 1;
            for (V v : vs) {
                if (checkCycle(v, res, vs)) {
                    return "";
                }
            }

            return new String(res);
        }

        private boolean checkCycle(V cur, char[] res, List<V> vs){
            if (cur.status == Status.Visiting) return true;
            if (cur.status == Status.Visited) return false;
            cur.status = Status.Visiting;

            for (V next : cur.nexts) {
                if (checkCycle(next, res, vs)) {
                    return true;
                }
            }

            cur.status = Status.Visited;
            res[curLab--] = cur.val;
            return false;
        }

        private void addVertex(V[] graph, char c, List<V> vs) {
            if (graph[c - 'a'] == null) {
                graph[c - 'a'] = new V(c);
                vs.add(graph[c - 'a']);
            }
        }
}
