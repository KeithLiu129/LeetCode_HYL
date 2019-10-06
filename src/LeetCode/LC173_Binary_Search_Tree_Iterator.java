package LeetCode;

//173. Binary Search Tree Iterator
//https://leetcode.com/problems/binary-search-tree-iterator/

import java.util.LinkedList;

public class LC173_Binary_Search_Tree_Iterator {
    LinkedList<TreeNode> stack;

    public LC173_Binary_Search_Tree_Iterator(TreeNode root) {
        stack = new LinkedList<>();
        pushLeft(root);
    }

    public int next() {
        TreeNode tmp = stack.pollFirst();
        if(tmp.right != null) {
            pushLeft(tmp.right);
        }
        return tmp.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushLeft(TreeNode root) {
        while(root != null)
        {
            stack.offerFirst(root);
            root = root.left;
        }
    }
}
