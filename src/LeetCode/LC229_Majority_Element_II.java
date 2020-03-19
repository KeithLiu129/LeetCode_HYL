package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC229_Majority_Element_II {
    public List<Integer> majorityElement(int[] nums) {

        int count1 = 0;
        int count2 = 0;
        Integer candidate1 = null;
        Integer candidate2 = null;

        for (int i = 0; i < nums.length; i++) {
            if (candidate1 != null && candidate1 == nums[i]) {
                count1++;
            }else if (candidate2 != null && candidate2 == nums[i]) {
                count2++;
            }else if (count1 == 0) {
                candidate1 = nums[i];
                count1 = 1;
            }else if (count2 == 0) {
                candidate2 = nums[i];
                count2 = 1;
            }else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for(int num : nums) {
            if (candidate1 != null && num == candidate1) count1++;
            if (candidate2 != null && num == candidate2) count2++;
        }

        List<Integer> res = new ArrayList<>();
        if (count1 > nums.length / 3) res.add(candidate1);
        if (count2 > nums.length / 3) res.add(candidate2);

        return res;
    }
}
