package LeetCode;

//191. Number of 1 Bits
//https://leetcode.com/problems/number-of-1-bits/

public class LC191_Number_Of_1_Bits {
    public int hammingWeight(int n) {
        int count = 0;

        while (n != 0) {
           if ((n & 1) != 0) count++;
           n >>>= 1;   // use unsigned shift w/e filled 0
        }
        return count;
    }
}
