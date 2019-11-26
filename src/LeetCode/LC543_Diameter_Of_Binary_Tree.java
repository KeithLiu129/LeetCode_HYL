package LeetCode;

public class LC543_Diameter_Of_Binary_Tree {
    public int diameterOfBinaryTree(TreeNode root) {
       if (root == null) return 0;
       return helper(root)[0];
    }

    private int[] helper(TreeNode root) {
        int[] res = new int[2];
        if (root == null) return res;
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        res[1] = Math.max(left[1], right[1]) + 1;
        res[0] = Math.max(left[0], Math.max(right[0], left[1] + right[1]));
        return res;
    }
}
