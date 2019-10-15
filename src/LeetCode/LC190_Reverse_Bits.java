package LeetCode;

//190. Reverse Bits
//https://leetcode.com/problems/reverse-bits/

public class LC190_Reverse_Bits {
    public int reverseBits(int n) {
        //cc
        if (n == 0) return 0;

        int mask = 0;
        int result = 0;

        for (int i = 0; i < 32; i++) {
            mask = n >> i & 1;
            result |= mask << (31 - i);
        }
        return result;
    }
}
