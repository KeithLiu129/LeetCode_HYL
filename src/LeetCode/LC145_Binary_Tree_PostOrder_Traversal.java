package LeetCode;

//145. Binary Tree Postorder Traversal
//https://leetcode.com/problems/binary-tree-postorder-traversal/

import java.util.LinkedList;
import java.util.List;

public class LC145_Binary_Tree_PostOrder_Traversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();

        if(root == null) return result;

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);

        while(!stack.isEmpty()) {
            TreeNode tmp = stack.pollFirst();
            result.addFirst(tmp.val); //Add the result to the beginning of the list.
            if (tmp.left != null) stack.offerFirst(tmp.left);
            if (tmp.right != null) stack.offerFirst(tmp.right);
        }

        return result;
    }
}
