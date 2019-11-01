package LeetCode;

//426. Convert Binary Search Tree to Sorted Doubly Linked List

public class LC426_Convert_Binary_Search_Tree_To_Doubly_Sorted_Linked_List {
    private TreeNode prev = null;
    private TreeNode head = null;
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;
        inorder(root);
        head.left = prev;
        prev.right = head;
        return head;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);
        //
        if (prev == null) head = root;
        else {
            prev.right = root;
            root.left = prev;
        }
        prev = root;

        inorder(root.right);
    }
}
