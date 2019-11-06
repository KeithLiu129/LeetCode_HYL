package LeetCode;

//18. 4Sum
//https://leetcode.com/problems/4sum/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC18_4Sum {
        public List<List<Integer>> fourSum(int[] nums, int target) {
            if (nums == null || nums.length < 4) return new ArrayList<>();

            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                    int sum = target - nums[i] - nums[j];
                    int lo = j + 1;
                    int hi = nums.length - 1;
                    while (lo < hi) {
                        int sum2 = nums[lo] + nums[hi];
                        if (sum2 == sum) {
                            res.add(Arrays.asList(nums[i], nums[j], nums[lo++], nums[hi--]));
                            while (lo < hi && nums[lo] == nums[lo - 1]) lo++;
                            while (lo < hi && nums[hi] == nums[hi + 1]) hi--;
                        }else if (sum2 < sum) {
                            lo++;
                        }else {
                            hi--;
                        }
                    }
                }
            }
            return res;
        }
}
