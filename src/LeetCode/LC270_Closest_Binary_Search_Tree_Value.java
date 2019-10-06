package LeetCode;

//270. Closest Binary Search Tree Value
//https://leetcode.com/problems/closest-binary-search-tree-value/

public class LC270_Closest_Binary_Search_Tree_Value {
    public int closestValue(TreeNode root, double target) {
        if(root == null) return 0;
        TreeNode cur = root;
        int res = root.val;
        while(cur != null) {
            if(Math.abs(cur.val - target) <= Math.abs(res - target)) res = cur.val;
            if (cur.val > target) {
                cur = cur.left;
            } else if (cur.val < target) {
                cur = cur.right;
            } else {
                return cur.val;
            }
        }
        return res;
    }
}
