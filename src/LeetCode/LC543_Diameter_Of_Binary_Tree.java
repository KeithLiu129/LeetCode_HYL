package LeetCode;

public class LC543_Diameter_Of_Binary_Tree {
        public int diameterOfBinaryTree(TreeNode root) {
            int[] res = new int[1];
            helper(root, res);
            return res[0];
        }

        private int helper(TreeNode root, int[] res) {
            if (root == null) return 0;
            int left = helper(root.left, res);
            int right = helper(root.right, res);
            int cur = left + right;
            res[0] = Math.max(cur, res[0]);
            return Math.max(left, right) + 1;
        }
    }
}
