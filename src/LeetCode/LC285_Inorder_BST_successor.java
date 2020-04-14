package LeetCode;

/**
 * ${recursion version}
 *
 * @author KeithLiu on 2020-03-30
 */

public class LC285_Inorder_BST_successor {

        TreeNode res;
        public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
            if (root == null || p == null) return null;
            if (root.val <= p.val) {
                return inorderSuccessor(root.right, p);
            }else {
                TreeNode left = inorderSuccessor(root.left, p);
                return (left != null) ? left : root;
            }
        }
    }
