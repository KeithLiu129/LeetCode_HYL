package LeetCode;

public class LC687_Longest_Univalue_Path {
    int res = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        int leftCount = 0, rightCount = 0;
        if (root.left != null && root.left.val == root.val) {
            leftCount = left + 1;
        }
        if (root.right != null && root.right.val == root.val) {
            rightCount = right + 1;
        }
        res = Math.max(res, leftCount + rightCount);
        return Math.max(leftCount, rightCount);
    }
}
