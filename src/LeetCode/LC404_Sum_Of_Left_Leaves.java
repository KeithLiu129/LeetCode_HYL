package LeetCode;

public class LC404_Sum_Of_Left_Leaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, false);

    }

    private int dfs(TreeNode root, boolean isLeft) {
        if (root == null) return 0;

        if (root.left == null && root.right == null && isLeft) return root.val;
        return dfs(root.left, true) + dfs(root.right, false);
    }
}
