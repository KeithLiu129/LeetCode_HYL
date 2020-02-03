package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC300_Longest_Increasing_Subsequence {
        public int lengthOfLIS(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            List<Integer> buffer = new ArrayList<>();

            for (int n : nums) {
                int index = getSmallestLarge(buffer, n);
                if (index == buffer.size()) {
                    buffer.add(n);
                }else {
                    buffer.set(index, n);
                }
            }
            return buffer.size();
        }

        private int getSmallestLarge(List<Integer> buffer, int val) {
            if (buffer.size() == 0) return 0;
            int start = 0;
            int end = buffer.size() - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                int cur = buffer.get(mid);
                if (cur == val) {
                    return mid;
                } else if (cur < val) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return start;
        }
    }
