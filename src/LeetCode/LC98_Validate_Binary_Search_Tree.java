package LeetCode;

//98. Validate Binary Search Tree

import java.util.List;

public class LC98_Validate_Binary_Search_Tree {
        public boolean isValidBST(TreeNode root) {
            return helper(root, null, null);
        }
        private boolean helper(TreeNode root, Integer lower, Integer upper) {
            if (root == null) return true;
            if ((lower != null && root.val <= lower) || (upper != null && root.val >= upper)) {
                return false;
            }
            return helper(root.left, lower, root.val) && helper(root.right, root.val, upper);
        }
}


