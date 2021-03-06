package LeetCode;

//100. Same Tree
//https://leetcode.com/problems/same-tree/submissions/

public class LC100_Same_Tree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null) return q == null;
        if(p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
