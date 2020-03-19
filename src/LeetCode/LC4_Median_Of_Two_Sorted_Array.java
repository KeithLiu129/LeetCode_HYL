package LeetCode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class LC4_Median_Of_Two_Sorted_Array {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //c.c.
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) return findMedianSortedArrays(nums2, nums1);
        int len = m + n;
        int start = 0;
        int end = m;
        int cur1, cur2;

        while (start <= end) {
            cur1 = (start + end)/ 2;
            cur2 = len / 2 - cur1;
            int L1 = (cur1 == 0) ? Integer.MIN_VALUE : nums1[cur1 - 1];
            int R1 = (cur1 == m) ? Integer.MAX_VALUE : nums1[cur1];
            int L2 = (cur2 == 0) ? Integer.MIN_VALUE : nums2[cur2 - 1];
            int R2 = (cur2 == n) ? Integer.MAX_VALUE : nums2[cur2];

            if (L1 > R2) {
                end = cur1 - 1;
            }else if (L2 > R1) {
                start = cur1 + 1;
            }else {
                if (len % 2 == 0) {
                    return (Math.max(L1, L2) + Math.min(R1, R2)) / 2.0;
                } else {
                    return Math.min(R1, R2);
                }
            }

            PriorityQueue<ArrayList> pq = new PriorityQueue<>(new Comparator<List>() {
                @Override
                public int compare(List o1, List o2) {
                    return o1.size() - o2.size();
                }
            });

        }
        return -1;
    }

}
