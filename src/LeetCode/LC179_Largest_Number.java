package LeetCode;

//179. Largest Number
//https://leetcode.com/problems/largest-number/

import java.util.Arrays;
import java.util.Comparator;

public class LC179_Largest_Number {
    private class LargestNumberComparator implements Comparator<String> {
        @Override
        public int compare(String s1, String s2) {
            String order1 = s1 + s2;
            String order2 = s2 + s1;
            return order2.compareTo(order1);
        }
    }
    public String largestNumber(int[] nums){
        String[] str = new String[nums.length];
        String res = new String();
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str, new LargestNumberComparator());
        if (str[0].equals("0")) {
            return "0";
        }

        for (String s : str) {
            res += s;
        }
        return res;
    }
}
