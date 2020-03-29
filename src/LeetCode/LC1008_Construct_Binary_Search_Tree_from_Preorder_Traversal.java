package LeetCode;

/**
 * ${Return the root node of a binary search tree that matches the given preorder traversal.}
 *
 * @author KeithLiu on 2020-03-29
 */

public class LC1008_Construct_Binary_Search_Tree_from_Preorder_Traversal {
        private int index = 0;
        public TreeNode bstFromPreorder(int[] preorder) {
            return helper(preorder, Integer.MAX_VALUE);
        }

        private TreeNode helper(int[] preorder, int bound) {
            if (index == preorder.length || preorder[index] >= bound) {
                return null;
            }

            TreeNode root = new TreeNode(preorder[index++]);
            TreeNode left = helper(preorder, root.val);
            TreeNode right = helper(preorder, bound);
            root.left = left;
            root.right = right;
            return root;
        }
    }
