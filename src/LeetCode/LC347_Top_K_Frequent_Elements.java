package LeetCode;

//347. Top K Frequent Elements
//https://leetcode.com/problems/top-k-frequent-elements/

import java.util.*;

public class LC347_Top_K_Frequent_Elements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();

        if(nums == null) return result;

        HashMap<Integer, Integer> maps = new HashMap<>();

        for (int i : nums) {
            maps.put(i, maps.getOrDefault(i, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                if (maps.get(i1).equals(maps.get(i2))) return 0;
                return maps.get(i1) > maps.get(i2) ? 1 : -1;
            }
        });

        for(int key : maps.keySet()) {
            if(minHeap.size() < k) {
                minHeap.offer(key);
            } else {
                int freq = maps.get(key);
                if(freq > maps.get(minHeap.peek())) {
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
