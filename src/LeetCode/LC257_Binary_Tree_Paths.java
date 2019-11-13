package LeetCode;

//257. Binary Tree Paths
//https://leetcode.com/problems/binary-tree-paths/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC257_Binary_Tree_Paths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;

        dfs(root,"", res);

        return res;
    }

    private void dfs(TreeNode cur, String s, List<String> res) {


        if (cur.left == null && cur.right == null) {
            s += cur.val;
            res.add(s);
            return;
        }
        s += cur.val + "->";
        if (cur.left != null) {
            dfs(cur.left, s, res);
        }
        if (cur.right != null) {
            dfs(cur.right, s, res);
        }
    }
}

