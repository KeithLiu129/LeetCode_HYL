package LeetCode;

//314. Binary Tree Vertical Order Traversal
//https://leetcode.com/problems/binary-tree-vertical-order-traversal/


import java.util.*;

public class LC314_Binary_Tree_Vertical_Order_Traversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>(); // <col, level>;

        nodeQueue.offer(root);
        cols.offer(0);

        int max = 0;
        int min = 0;

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int col = cols.poll();

            if (!map.containsKey(col)) {
                map.put(col, new LinkedList<>());
            }
            map.get(col).add(node.val);

            if (node.left != null) {
               nodeQueue.offer(node.left);
               cols.offer(col - 1);
               min = Math.min(min, col - 1);
            }
            if (node.right != null) {
                nodeQueue.offer(node.right);
                cols.offer(col + 1);
                max = Math.max(max, col + 1);
            }
        }

        for (int i = min; i <= max; i++) {
            result.add(map.get(i));
        }
        return result;
    }
}

