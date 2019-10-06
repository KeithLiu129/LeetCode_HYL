package LeetCode;

//111. Minimum Depth of Binary Tree
//https://leetcode.com/problems/minimum-depth-of-binary-tree/

import java.util.LinkedList;
import java.util.Queue;

public class LC111_Minimum_Depth_of_Binary_Tree {
    public int minDepth(TreeNode root) {
        //recursion
        /*
        if(root == null) return 0;
        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);

        if(root.left != null & root.right != null) {
            return Math.min(leftMinDepth, rightMinDepth) + 1;
        }else {
            return root.left == null ? rightMinDepth + 1 : leftMinDepth + 1;
        }

        */

        //Iteration
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        int depth = 0;

        q.offer(root);
        while (!q.isEmpty()) {
            depth++;
            int size = q.size();
            TreeNode tmp = q.poll();
            if (tmp.left == null && tmp.right == null) break;
            else {
                depth++;
                if (tmp.left != null) q.offer(tmp.left);
                if (tmp.right != null) q.offer(tmp.right);
            }
        }
        return depth;

    }
}
