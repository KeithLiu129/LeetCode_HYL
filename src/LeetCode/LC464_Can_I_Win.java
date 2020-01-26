package LeetCode;

public class LC464_Can_I_Win {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger <= 0 || maxChoosableInteger > 20 || desiredTotal < 0 || desiredTotal > 300) return false;

        //if (maxChoosableInteger >= desiredTotal) return true;

        int sum = (maxChoosableInteger + 1) * maxChoosableInteger / 2;
        if (sum < desiredTotal) return false;

        int pool = (1 << maxChoosableInteger) - 1;
        Boolean[] mem = new Boolean[pool + 1];
        return dfs (pool, 0, desiredTotal, maxChoosableInteger, mem);
    }

    private boolean dfs(int pool, int sum, int target, int max, Boolean[] mem) {

        if (mem[pool] != null) return mem[pool];

        for (int i = 1; i <= max; i++) {
            int mask = 1 << (i - 1);
            if ((mask & pool) != 0) {
                if (i + sum >= target) {
                    mem[pool] = true;
                    return true;
                }
                if ( !dfs(pool - mask, sum + i, target, max, mem)) {
                    mem[pool] = true;
                    return true;
                }
            }

        }

        mem[pool] = false;
        return false;
    }
}
