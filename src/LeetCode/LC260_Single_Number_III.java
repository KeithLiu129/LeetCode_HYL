package LeetCode;

//260. Single Number III
//https://leetcode.com/problems/single-number-iii/

import java.util.HashMap;
import java.util.Map;

public class LC260_Single_Number_III {
    public int[] singleNumber(int[] nums) {
        /*

        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int[] res = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            if (item.getValue() == 1) res[index++] = item.getKey();
        }

        return res;

        */
        //cc
        int[] res = new int[2];
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }

        int lastBit =xor & (-xor); //get left most 1's of xor
        int group1 =0, group2 = 0;

        for (int i = 0; i< nums.length; i++) {
            if ((nums[i] & lastBit) == 0) group1 ^= nums[i];
            else group2 ^= nums[i];
        }
        res[0] = group1;
        res[1] = group2;

        return res;
    }
}
