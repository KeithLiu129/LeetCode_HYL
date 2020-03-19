package LeetCode;

//1. Two Sum
//https://leetcode.com/problems/two-sum/


import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingDeque;

public class LC1_Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) return new int[0];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) return new int[] {map.get(complement),i};
            map.put(nums[i], i);
        }
        return new int[0];
        String.hashCode();

        String s = "acb";
        s = s + 'b';


    }

    public static void main(String[] args) {

        String s = "acb";
        s = s + 'b';
        System.out.println(s);
    }
}
