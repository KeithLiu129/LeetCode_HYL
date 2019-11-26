package testing;

import java.util.*;

class Solution {
    public static boolean canCross(int[] stones) {
        if (stones == null || stones.length <= 1) return false;
        if (stones[1] - stones[0] != 1) return false;

        HashMap<Integer, Boolean>[] mems = new HashMap[stones.length];
        for (int i = 0; i < stones.length; i++) {
            mems[i] = new HashMap<>();
        }
        return dfs(stones, 1, 1, mems);
    }

    private static boolean dfs(int[] stones, int index, int k, HashMap<Integer, Boolean>[] mems) {
        HashMap<Integer, Boolean> map = mems[index];
        if (map.containsKey(k)) return map.get(k);

        int len = stones.length;
        if (index == len - 1) return true;

        for (int i = index + 1; i < len; i++) {
            int dis = stones[i] - stones[index];
            if (dis < k - 1) continue;
            if (dis > k + 1) break;

            if (dis == k - 1 || dis == k || dis == k + 1){
                if(dfs(stones, i, dis, mems)) {
                    map.put(k, true);
                    return true;
                }
            }

        }
        map.put(k, false);
        return false;
    }

    public static void main(String[] args) {
        int[] input = {0, 1, 2, 3, 4, 8, 9, 11};
        System.out.println(canCross(input));
    }
}



