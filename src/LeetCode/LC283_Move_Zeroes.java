package LeetCode;

//283. Move Zeroes
//https://leetcode.com/problems/move-zeroes/

public class LC283_Move_Zeroes {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int size = nums.length;
        int slow = 0;
        int fast = 0;
        while (fast <  size) {
            if (nums[fast] != 0) {
                nums[slow++] = nums[fast++];
            }else {
                fast++;
            }
        }
        while (slow < size) {
            nums[slow++] = 0;
        }
    }
}
