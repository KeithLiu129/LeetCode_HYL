package LeetCode;

//222. Count Complete Tree Nodes
//https://leetcode.com/problems/count-complete-tree-nodes/

public class LC222_Count_Complete_Tree_Nodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        if (leftHeight > rightHeight) {
            return countNodes(root.left) + (int)Math.pow(2, rightHeight); // n = 2^h  - 1;
        } else if (leftHeight == rightHeight) {
            return countNodes(root.right) + (int)Math.pow(2, leftHeight);
        } else {
            return 0;
        }

    }

    private int maxDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth ++;
        }
        return depth;
    }
}
