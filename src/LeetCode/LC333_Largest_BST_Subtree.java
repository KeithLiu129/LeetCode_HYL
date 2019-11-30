package LeetCode;

public class LC333_Largest_BST_Subtree {
    public int res;

    public int largestBSTSubtree(TreeNode root) {

    if (root == null) return 0;
    dfs(root);
    return res;

    }

    private Result dfs(TreeNode root) {
        int min, max, size;
        if (root == null) return new Result(0, 0, 0);

        Result left = dfs (root.left);
        Result right = dfs(root.right);

        if (root == null || root == null || left.max > root.val || right.min > root.val) {
            return null;
        }else {
            min = (root.left == null) ? root.val : left.min;
            max = (root.right == null) ? root.val : left.max;
            size = left.size + right.size + 1;
            res = Math.max(res, size);
        }
        return new Result(min, max, size);
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
