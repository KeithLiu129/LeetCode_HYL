package LeetCode;

//94. Binary Tree Inorder Traversal
//https://leetcode.com/problems/binary-tree-inorder-traversal/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC94_Binary_Tree_Inorder_Traversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        /*
        //recursion
        List<Integer> res = new ArrayList<>();

        if(root == null) return res;

        res.addAll(inorderTraversal(root.left));
        res.add(root.val);
        res.addAll(inorderTraversal(root.right));

        return res;
        */

        //Iteration
        List<Integer> res = new ArrayList<>();

        if(root == null) return res;

        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;

        while(!stack.isEmpty() || cur != null) {
            while(cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            }
            cur = stack.pollFirst();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;



    }
}
