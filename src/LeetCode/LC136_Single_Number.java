package LeetCode;

//136. Single Number
//https://leetcode.com/problems/single-number/

public class LC136_Single_Number {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) throw new IllegalArgumentException("the number doesnt exist");

        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        LC136_Single_Number sol = new LC136_Single_Number();
        int[] test = new int[]{};
        System.out.println(sol.singleNumber(test));
    }
}
