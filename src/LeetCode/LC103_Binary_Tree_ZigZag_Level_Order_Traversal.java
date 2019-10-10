package LeetCode;

//103. Binary Tree Zigzag Level Order Traversal
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC103_Binary_Tree_ZigZag_Level_Order_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();

        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        boolean isEven = false;

        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if (!isEven) {
                    level.add(node.val);
                } else {
                    level.addFirst(node.val);
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            isEven = !isEven;
            result.add(level);
        }

        return result;

    }
}
