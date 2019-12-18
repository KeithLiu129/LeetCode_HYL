package LeetCode;

public class LC776_Split_BST {
    public TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null) return new TreeNode[]{null, null};
        if (root.val > V) {
            TreeNode[] ans = splitBST(root.left, V);
            root.left = ans[1];
            ans[1] = root;
            return ans;
        } else {
            TreeNode[] ans = splitBST(root.right, V);
            root.right = ans[0];
            ans[0] = root;
            return ans;
        }
    }
}
