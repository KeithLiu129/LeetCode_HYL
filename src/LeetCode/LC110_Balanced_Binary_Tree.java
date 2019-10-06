package LeetCode;

//110. Balanced Binary Tree
//https:leetcode.com/problems/balanced-binary-tree/


public class LC110_Balanced_Binary_Tree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        LC104_Maximum_Depth_of_Binary_Tree sol = new LC104_Maximum_Depth_of_Binary_Tree();

        int diff = Math.abs(sol.maxDepth(root.left) - sol.maxDepth(root.right));
        if (diff > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static void main(String[] args) {
        LC110_Balanced_Binary_Tree sol = new LC110_Balanced_Binary_Tree();
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode lright = new TreeNode(4);
        TreeNode rright = new TreeNode(5);
        TreeNode lrright = new TreeNode(6);
        root.left = left;
        root.right = right;
        right.left = lright;
        right.right = rright;
        rright.left = lrright;



        boolean res = sol.isBalanced(root);
        System.out.println(res);
    }
}


