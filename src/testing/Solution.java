package testing;


import java.util.*;

class Solution {
    static int res = 0;
    public static int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        dfs(root);
        return res;

    }

    private static Result dfs(TreeNode root) {
        int min, max, size;
        if (root == null) return new Result(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        Result left = dfs(root.left);
        Result right = dfs(root.right);

        if (left == null || right == null || left.max >= root.val || right.min < root.val) {
            return null;
        }else {
            min = (root.left == null) ? root.val : left.min;
            max = (root.right == null) ? root.val : left.max;
            size = left.size + right.size + 1;
            res = Math.max(res, size);
        }
        return new Result(min, max, size);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = null;
        root.right = null;
        System.out.println(largestBSTSubtree(root));
    }
}

class Result {
    public int min, max, size;

    public Result(int min, int max, int size) {
        this.min = min;
        this.max = max;
        this.size = size;
    }
}

class TreeNode {
    int val;
    TreeNode left, right;
    public TreeNode(int val) {
        this.val = val;
    }

}



