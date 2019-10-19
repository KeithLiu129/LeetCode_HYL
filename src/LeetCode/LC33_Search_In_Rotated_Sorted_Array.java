package LeetCode;

//33. Search in Rotated Sorted Array
//https://leetcode.com/problems/search-in-rotated-sorted-array/

public class LC33_Search_In_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) return mid;
            if (target == nums[left]) return left;
            if (target == nums[right]) return right;


            if (nums[left] < nums[mid]) {
                if (target < nums[mid] && target > nums[left]) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
            else {
                if (target > nums[mid] && target < nums[right]) {
                    left = mid + 1;
                }
                else right = mid - 1;
            }
        }
        return -1;
    }

}
