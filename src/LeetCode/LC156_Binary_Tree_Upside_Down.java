package LeetCode;

//156. Binary Tree Upside Down
//https://leetcode.com/problems/binary-tree-upside-down/

public class LC156_Binary_Tree_Upside_Down {
    public TreeNode upsideDownBinaryTree(TreeNode root){
        if (root == null || root.left == null) return root;

        TreeNode newRoot = upsideDownBinaryTree(root.left);

        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;

        return newRoot;
    }
}
