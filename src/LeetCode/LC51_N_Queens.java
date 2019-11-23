package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC51_N_Queens {
    public List<List<String>> solveNQueens(int n) {
        if (n < 0) throw new IllegalArgumentException("no such solution");
        List<List<String>> res = new ArrayList<>();
        dfs(0, n, res, new ArrayList<String>());
        return res;
    }

    private void dfs(int level, int n, List<List<String>> res, List<String> path){
        if (path.size() == n) {
            List<String> tmp = new ArrayList<>();
            for (String s : path) {
                tmp.add(s);
            }
            res.add(tmp);
        }

        for (int i = 0; i < n; i++) {
            char[] arr = new char[n];
            for (int j = 0; j < n; j++) {
                arr[j] = '.';
            }
            arr[i] = 'Q';
            path.add(new String(arr));
            if(isValid(path, level, i)) {
                dfs(level + 1, n, res, path);
            }
            //wall
            path.remove(path.size() - 1);
        }
    }

    private boolean isValid(List<String> path, int level, int col){
        if (path == null || path.size() == 0) return false;
        for (int i = 0; i < level; i++) {
            if (path.get(i).charAt(col) == 'Q') return false;
        }
        for (int i = 0; i < level; i++) {
            int prev = path.get(i).indexOf('Q');
            if (Math.abs(prev - col) == level - i) return false;
        }
        return true;
    }
}
