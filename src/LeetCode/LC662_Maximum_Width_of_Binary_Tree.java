package LeetCode;

//662. Maximum Width of Binary Tree
//https://leetcode.com/problems/maximum-width-of-binary-tree/

import java.util.LinkedList;
import java.util.Queue;

public class LC662_Maximum_Width_of_Binary_Tree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> indexQueue = new LinkedList<>();
        int max = 0;

        nodeQueue.offer(root);
        indexQueue.offer(0);

        //bfs
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            int left = 0, right = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = nodeQueue.poll();
                int index = indexQueue.poll();

                if (i == 0) left = index; //starting point index
                if (i == size - 1) right = index; //end point index

                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    indexQueue.offer(index * 2);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    indexQueue.offer(index * 2 + 1);
                }
            }
            max = Math.max(max, right - left + 1);

        }
        return max;
    }
}

//DFS TODO
