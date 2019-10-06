package LeetCode;

//783. Minimum Distance Between BST Nodes
//https://leetcode.com/problems/minimum-distance-between-bst-nodes/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC783_Minimum_Distance_Between_BST_Nodes {
    public int minDiffInBST(TreeNode root) {
        Integer[] result = new Integer[2];
        result[1] = Integer.MAX_VALUE;
        inorderTraversal(root, result);
        return result[1];
    }

    private void inorderTraversal(TreeNode root, Integer[] result) {
        if(root == null) return;

        inorderTraversal(root.left, result);
        if(result[0] != null) {
            result[1] = Math.min(root.val - result[0], result[1]);
        }
        result[0] = root.val;
        inorderTraversal(root.right, result);
    }
}
