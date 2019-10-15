package LeetCode;

//12. Integer to Roman
//https://leetcode.com/problems/integer-to-roman/


public class LC12_Integer_To_Roman {
    public String intToRoman(int num) {
        //assume num is from 1 to 3999
        //i.e num = 1994
        StringBuilder sb = new StringBuilder();

        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < nums.length; i++) {
            while (num >= nums[i]) {
                num -= nums[i];
                sb.append(romans[i]);
            }
        }
        return sb.toString();
    }

}
