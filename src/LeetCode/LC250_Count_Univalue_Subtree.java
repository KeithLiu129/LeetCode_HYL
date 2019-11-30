package LeetCode;

public class LC250_Count_Univalue_Subtree {
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        dfs(root, count);
        return count[0];
    }

    private boolean dfs(TreeNode root, int[] count) {
        if (root == null) return true;
        //post-order
        boolean L = dfs(root.left, count);
        boolean R = dfs(root.right, count);
        if (L && R ) {
            if (root.left != null && root.left.val == root.val) {
                return false;
            }
            if (root.right != null && root.right.val == root.val) {
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }
}
