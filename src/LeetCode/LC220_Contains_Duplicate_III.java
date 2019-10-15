package LeetCode;

//220. Contains Duplicate III
//https://leetcode.com/problems/contains-duplicate-iii/


import java.util.Set;
import java.util.TreeSet;

public class LC220_Contains_Duplicate_III {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0) return false;

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.size() > k) set.remove(Long.valueOf(nums[i - k - 1]));
            Long upper = (long)nums[i] + t;
            Long lower = (long)nums[i] - t;

            Long temp = set.lower(upper + 1);

            if (temp != null && temp >= lower) return true;
            set.add(Long.valueOf(nums[i]));

        }

        return false;
    }
}
