package LeetCode;

//217. Contains Duplicate
//https://leetcode.com/problems/contains-duplicate/

import java.util.HashSet;
import java.util.Set;

public class LC217_Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;

        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            if(!set.add(i)) return true;
        }
        return false;

    }
}
