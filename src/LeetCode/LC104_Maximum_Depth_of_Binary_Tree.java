package LeetCode;

//104. Maximum Depth of Binary Tree
//https://leetcode.com/problems/maximum-depth-of-binary-tree/submissions/


import java.util.LinkedList;
import java.util.Queue;

public class LC104_Maximum_Depth_of_Binary_Tree {
    public int maxDepth(TreeNode root) {
        //recursion
        /*
        if(root == null) return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right));
        */

        //iteration
        if(root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        int depth = 0;

        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();

            while(size-- > 0) {
                TreeNode tmp = q.poll();
                if(tmp.left != null) q.offer(tmp.left);
                if(tmp.right != null) q.offer(tmp.right);
            }
            depth++;
        }
        return depth;

    }
}
