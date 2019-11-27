package LeetCode;

public class LC114_FLatten_Binary_Tree_TO_Linked_List {
    private TreeNode pre;
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }
}
