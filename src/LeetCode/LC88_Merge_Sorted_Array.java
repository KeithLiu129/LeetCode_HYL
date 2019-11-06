package LeetCode;

//88. Merge Sorted Array
//https://leetcode.com/problems/merge-sorted-array/

public class LC88_Merge_Sorted_Array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1 == null || nums2 == null) return;

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (k >= 0) {
            if (i < 0) {
                while (j >= 0) {
                    nums1[k--] = nums2[j--];
                }
                return;
            }
            if (nums1[i] >= nums2[j]) {
                nums1[k--] = nums1[i--];
            }else {
                nums1[k--] = nums2[j--];
            }
        }
    }
}
