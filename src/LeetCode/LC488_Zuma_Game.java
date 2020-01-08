package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LC488_Zuma_Game {
    private int min;
    public int findMinStep(String board, String hand) {
        if (board == null || board.length() == 0 || hand == null || hand.length() == 0) return -1;

        min = hand.length() + 1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : hand.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }

        dfs(board, map, 0);

        return min == hand.length() + 1 ? -1 : min;
    }

    private void dfs(String board, HashMap<Character, Integer> map, int used) {
        int len = board.length();
        if (len == 0) {
            if (min > used) {
                min = used;
            }
            return;
        }

        for (int i = 0; i < board.length(); i++) {
            char c = board.charAt(i);
            if (!map.containsKey(c)) continue;

            int count = map.get(c);

            //add one ball
            if (i < len - 1 && c == board.charAt(i + 1)) {
                int newCount = map.remove(c) - 1;
                if (newCount > 0) {
                    map.put(c, newCount);
                }

                String newBoard = removeBalls(board, i - 1, i + 2);
                dfs(newBoard, map, used + 1);
                //wall
                map.put(c, count); //backTracking
            }else if(count >= 2) {
                //add two balls
                map.remove(c);
                if (count > 2) {
                    map.put(c, count - 2);
                }

                String newBoard = removeBalls(board, i - 1, i + 1);

                dfs(newBoard, map, used + 2);
                //wall
                map.put(c, count);
            }
        }
    }

    private String removeBalls(String board, int left, int right) {

        //left and right are two bounds

        int len = board.length();

        while (left >= 0 && right < len) {
            char c = board.charAt(left);
            int count = 0;

            int l = left;
            while (l >= 0 && board.charAt(l) == c) {
                l--;
                count++;
            }

            int r = right;
            while (r < len && board.charAt(r) == c) {
                r++;
                count++;
            }

            if (count >= 3) {
                left = l;
                right = r;
            }else {
                break;
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= left; i++) {
            sb.append(board.charAt(i));
        }
        for (int i = right; i < board.length(); i++) {
            sb.append(board.charAt(i));
        }
        return sb.toString();
    }
}
