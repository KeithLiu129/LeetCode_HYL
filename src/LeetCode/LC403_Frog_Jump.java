package LeetCode;

import java.util.HashMap;

public class LC403_Frog_Jump {
    public boolean canCross(int[] stones) {
        if (stones == null || stones.length <= 1) return false;
        if (stones[1] - stones[0] != 1) return false;
        HashMap<Integer, Boolean>[] mems = new HashMap[stones.length];
        for (int i = 0; i < stones.length; i++) {
            mems[i] = new HashMap<>();
        }
        return dfs(stones, 1, 1, mems);
    }

    private boolean dfs(int[] stones, int index, int k, HashMap<Integer, Boolean>[] mems) {
        HashMap<Integer, Boolean> map = mems[index];
        if (map.containsKey(k)) return map.get(k);

        int len = stones.length;
        if (index == len - 1) return true;

        for (int i = index + 1; i < len; i++) {
            int dis = stones[i] - stones[index];
            if (dis < k - 1) continue;
            if (dis > k + 1) break;

            if (dis == k - 1 || dis == k || k == k + 1){
                if(dfs(stones, i, dis, mems)) {
                    map.put(k, true);
                    return true;
                }
            }
        }
        map.put(k, false);
        return false;
    }
}
