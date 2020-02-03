package LeetCode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class LC496_Next_Greater_Element {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        //c.c
        int[] res = new int[nums1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums2.length; i++) {
            int cur = nums2[i];
            while (!stack.isEmpty() && stack.peekFirst() < cur) {
                map.put(stack.pollFirst(),cur);
            }
            stack.offerFirst(cur);
        }
        for (int i = 0; i < nums1.length; i++) {
            int cur = nums1[i];
            res[i] = map.getOrDefault(cur, -1);
        }

        return res;
    }
}
