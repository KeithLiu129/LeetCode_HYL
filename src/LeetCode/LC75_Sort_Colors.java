package LeetCode;

//75. Sort Colors
//https://leetcode.com/problems/sort-colors/

public class LC75_Sort_Colors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int i = 0;
        int j = 0;
        int k = nums.length - 1;

        while (j <= k) {
            if (nums[j] == 1) {
                j++;
            }else if (nums[j] == 0) {
                swap(nums, i, j);
                i++;
                j++;
            }else {
                swap(nums, j, k);
                k--;
            }
        }
    }

    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
