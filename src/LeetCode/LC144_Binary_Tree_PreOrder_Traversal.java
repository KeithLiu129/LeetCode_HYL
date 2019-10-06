package LeetCode;

//144. Binary Tree Preorder Traversal
//https://leetcode.com/problems/binary-tree-preorder-traversal/

import java.util.LinkedList;
import java.util.List;


public class LC144_Binary_Tree_PreOrder_Traversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        //Recursion solution
        /*
        if(root == null) return null;
        List<Integer> list = new LinkedList<>();
        list.add(root.val);
        list.addAll(preorderTraversal(root.left));
        list.addAll(preorderTraversal(root.right));
        return list;
        */

        //Iteration
        List<Integer> result = new LinkedList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        if(root == null) return result;
        stack.offerFirst(root);
        while(!stack.isEmpty()) {
            TreeNode tmp = stack.pollFirst();
            result.add(tmp.val);
            if (tmp.right != null) stack.offerFirst(tmp.right);
            if (tmp.left != null) stack.offerFirst(tmp.left);
        }

        return result;
    }
}
