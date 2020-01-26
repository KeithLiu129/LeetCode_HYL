package LeetCode;

public class LC129_Sum_Root_To_Leaf_Value {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int prev) {
        if (root == null) return 0;

        int sum = 10 * prev + root.val;
        if (root.left != null && root.right != null) {
            return sum;
        }
        return dfs(root.left, sum) + dfs(root.right, sum);
     }
}
