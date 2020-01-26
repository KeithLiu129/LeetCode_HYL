package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LC294_Flip_Game_II {
    public boolean canWin(String s) {
        Map<String, Boolean> map = new HashMap<>();
        char[] board = s.toCharArray();
        return dfs(board, map);
    }

    private boolean dfs(char[] board, Map<String, Boolean> map) {
        int len = board.length;
        Boolean ret = map.get(String.valueOf(board));
        if (ret != null) return ret;
        for (int i = 0; i < len - 1; i++) {
            if (board[i] == '+' && board[i + 1] == '+') {
                board[i] = '-';
                board[i + 1] = '-';
                boolean res = dfs(board, map);
                board[i] = '+';
                board[i + 1] = '+';
                if (!res) {
                    map.put(new String(board), true);
                    return true;
                }
            }
        }
        map.put(String.valueOf(board), false);
        return false;
    }
}

