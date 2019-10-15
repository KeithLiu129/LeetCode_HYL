package LeetCode;

//137. Single Number II
//https://leetcode.com/problems/single-number-ii/

public class LC137_Single_Number_II {
    public int singleNumber(int[] nums){
        //if (nums == null || nums.length == 0) return 0;

        int res = 0;

        for (int i = 0; i < 32; i++) {
            int digitSum = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] >> i & 1) == 1) digitSum++;
                digitSum %= 3;
            }

            if (digitSum != 0) res |= 1 << i;
        }

        return res;
    }
}
