package LeetCode;

public class LC450_Delete_Node_In_A_BST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return root;

        if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        else if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            TreeNode minNode = Successor(root.right);
            root.val = minNode.val;
            root.right  = deleteNode(root.right, root.val);

        }
        return root;
    }

    private TreeNode Successor(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
