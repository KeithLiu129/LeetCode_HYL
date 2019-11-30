package LeetCode;

public class LC298_Binary_Tree_Longest_Consecutive_Sequence {
    int max = 1;
    public int longestConsecutive(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs (TreeNode root) {
        if (root == null) return 0;
        int res = 1;
        int left = dfs(root.left);
        int right = dfs(root.right);

        if (root.left != null && root.val - 1 == root.left.val) {
            res = left + 1;
        }

        if (root.right != null && root.val - 1 == root.right.val) {
            res = right + 1;
        }

        max = Math.max(max, res);
        return res;
    }
}
