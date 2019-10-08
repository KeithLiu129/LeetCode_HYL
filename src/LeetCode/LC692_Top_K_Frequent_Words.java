package LeetCode;

//692. Top K Frequent Words
//https://leetcode.com/problems/top-k-frequent-words/

import java.util.*;

public class LC692_Top_K_Frequent_Words {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();

        if (words == null || words.length == 0) return result;

        HashMap<String, Integer> maps = new HashMap<>();
        PriorityQueue<String> minHeap = new PriorityQueue<>(k, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (maps.get(o1).equals(maps.get(o2))) return o2.compareTo(o1);
                return maps.get(o1) < maps.get(o2) ? -1 : 1;
            }
        });

        for (String s : words) {
            maps.put(s, maps.getOrDefault(s, 0) + 1);
        }

        for(String key : maps.keySet()) {
            if(minHeap.size() < k) {
                minHeap.offer(key);
            } else {
                if(maps.get(key) >= maps.get(minHeap.peek())) {
                    minHeap.offer(key);
                    minHeap.poll();
                }
            }
        }

        while(!minHeap.isEmpty()) {
            result.add(0, minHeap.poll());
        }

        return result;
    }
}
