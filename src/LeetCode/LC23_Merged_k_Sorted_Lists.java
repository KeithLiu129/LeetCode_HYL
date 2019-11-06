package LeetCode;

//23. Merge k Sorted Lists
//https://leetcode.com/problems/merge-k-sorted-lists/

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC23_Merged_k_Sorted_Lists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        int size = lists.length;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(size, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode cur = null;
        ListNode head = null;

        for (int i = 0; i < size; i++) {
            minHeap.offer(lists[i]);
        }

        while (!minHeap.isEmpty()) {
            ListNode temp = minHeap.poll();
            if (head == null) {
                head = temp;
                cur = head;
            }else {
                cur.next = temp;
                cur = cur.next;
            }
            if (temp.next != null) {
                minHeap.offer(temp.next);
            }
        }

        return head;
    }
}
