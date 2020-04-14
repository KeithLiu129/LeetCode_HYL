package LeetCode;

//103. Binary Tree Zigzag Level Order Traversal
//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

import java.util.*;

public class LC103_Binary_Tree_ZigZag_Level_Order_Traversal {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;

            Deque<TreeNode> q = new LinkedList<>();
            q.offer(root);
            boolean leftToRight = true;
            while (!q.isEmpty()) {
                int size = q.size();
                List<Integer> level = new ArrayList<>();
                TreeNode cur = null;
                for (int i = 0; i < size; i++) {
                    if (leftToRight) {
                        cur = q.pollFirst();
                        if (cur.left != null) q.offerLast(cur.left);
                        if (cur.right != null) q.offerLast(cur.right);
                    }else {
                        cur = q.pollLast();
                        if (cur.right != null) q.offerFirst(cur.right);
                        if (cur.left != null) q.offerFirst(cur.left);
                    }
                    level.add(cur.val);

                }
                res.add(level);
                leftToRight = !leftToRight;
            }

            return res;
        }
    }