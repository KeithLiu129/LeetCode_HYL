package LeetCode;

import java.util.PriorityQueue;

public class LC295_Find_Median_From_Data_Stream {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public LC295_Find_Median_From_Data_Stream() {
        minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num <= maxHeap.peek()) maxHeap.offer(num);
        else {
            minHeap.offer(num);
        }
        if (maxHeap.size() == minHeap.size() + 2) {
            minHeap.offer(maxHeap.poll());
        }

        if (maxHeap.size() == minHeap.size() - 1) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedian() {
          if (minHeap.size() == maxHeap.size()) {
              return (minHeap.peek() + maxHeap.peek()) / 2.0;
          }
          return (double)maxHeap.peek();
    }
}
