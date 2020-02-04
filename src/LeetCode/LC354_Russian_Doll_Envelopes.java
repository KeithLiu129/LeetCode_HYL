package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class LC354_Russian_Doll_Envelopes {
    public int maxEnvelopes(int[][] envelopes) {

        if (envelopes == null || envelopes.length == 0 || envelopes[0] == null || envelopes[0].length == 0) return 0;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                }else {
                    return a[0] - b[0];
                }
            }
        });

        int[] LIS = new int[envelopes.length];
        int len = 0;
        for (int[] item : envelopes) {
            int index = Arrays.binarySearch(LIS, 0, len, item[1]); //find insertion point, return  -insert - 1
            if (index < 0) {
                index = -index - 1;
            }
            LIS[index] = item[1];
            if (len == index) {
                len++;
            }
        }

        return len;

    }
}
