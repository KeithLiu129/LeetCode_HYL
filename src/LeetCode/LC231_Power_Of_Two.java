package LeetCode;

//231. Power of Two
//https://leetcode.com/problems/power-of-two/

public class LC231_Power_Of_Two {
    public boolean isPowerOfTwo(int n) {
        LC191_Number_Of_1_Bits sol = new LC191_Number_Of_1_Bits();
        int count = sol.hammingWeight(n);
        return count == 1;
    }


    public static void main(String[] args) {
        LC231_Power_Of_Two sol = new LC231_Power_Of_Two();
        System.out.println(sol.isPowerOfTwo(17));
        System.out.println(sol.isPowerOfTwo(16));
    }
}
