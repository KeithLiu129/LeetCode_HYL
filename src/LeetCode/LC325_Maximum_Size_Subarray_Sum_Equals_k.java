package LeetCode;

import java.util.HashMap;

/**
 * ${Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.}
 *
 * @author KeithLiu on 2020-04-14
 */

public class LC325_Maximum_Size_Subarray_Sum_Equals_k {
        public int maxSubArrayLen(int[] nums, int k) {

            //c.c.
            if (nums.length == 0 && k == 0) return 0;
            int[] preSum = new int[nums.length + 1]; //    [0, i]
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 1; i <= nums.length; i++) {
                preSum[i] = preSum[i - 1] + nums[i - 1];
            }
            int max = 0;
            for (int i = 0; i <= nums.length; i++) {
                int right = preSum[i];
                int left = right - k;
                if (map.containsKey(left)) {
                    max = Math.max(max, i - map.get(left));
                }
                map.putIfAbsent(right, i);
            }

            return max;
        }
}
