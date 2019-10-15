package LeetCode;

//69. Sqrt(x)
//https://leetcode.com/problems/sqrtx/

public class LC69_Sqrt_X {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        if (x == 1) return 1;

        int start = 1, end = x;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (mid == x / mid) return mid;
            else if (mid > x / mid) {
                end = mid;
            }else {
                start = mid;
            }
        }

        return end < (x / end) ? end : start;
    }
}
