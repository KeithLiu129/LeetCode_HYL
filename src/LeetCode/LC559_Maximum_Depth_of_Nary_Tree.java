package LeetCode;

//559. Maximum Depth of N-ary Tree
//https://leetcode.com/problems/maximum-depth-of-n-ary-tree/

import java.util.LinkedList;
import java.util.Queue;

public class LC559_Maximum_Depth_of_Nary_Tree {
    public int maxDepth(Node root) {
       //recursion
        /*
        if (root == null) return 0;
        int depth = 0;
        for(Node n : root.children) {
            depth = Math.max(maxDepth(n), depth);
        }
        return depth + 1;
        */
        if(root == null) return 0;
        int depth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
                while(size-- > 0) {
                    Node tmp = queue.poll();
                for (Node n : tmp.children) {
                    queue.offer(n);
                }
            }
            depth++;
        }
        return depth;
    }
}
