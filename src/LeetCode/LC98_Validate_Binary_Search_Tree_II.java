package LeetCode;

/**
 * ${Description}
 *
 * @author KeithLiu on 2020-03-30
 */

public class LC98_Validate_Binary_Search_Tree_II {
        TreeNode prev;
        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
            boolean left = isValidBST(root.left);
            if (!left) return false;
            if (prev != null && prev.val >= root.val) return false;
            prev = root;
            return isValidBST(root.right);
        }
}
