package LeetCode;

import java.util.*;

public class LC742_Closest_Leaf_In_A_Binary_Tree {
    public int findClosestLeaf(TreeNode root, int k) {
        //build graph, use dfs to find the node has value of k
        //use bfs to find the closest node to target k

        HashMap<TreeNode, TreeNode> map = new HashMap<>(); // <node, parentNode>
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> set = new HashSet<>();// dedup

        TreeNode target = findNode(root, k, map);

        q.offer(root);
        set.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur.left == null && cur.right == null) return cur.val;
            if (cur.left != null && set.add(cur.left)) {
                q.offer(cur.left);
            }
            if (cur.right != null && set.add(cur.right)) {
                q.offer(cur.right);
            }
            if (map.containsKey(cur) && set.add(map.get(cur))) {
                q.offer(map.get(cur));
            }

        }

        return -1;
    }

    private TreeNode findNode(TreeNode root, int k, HashMap<TreeNode, TreeNode> map) {
        if (root == null) return null;
        if (root.val == k) return root;

        if (root.left != null) {
            map.put(root.left, root);
            TreeNode left = findNode(root.left, k, map);
            if (left != null) return left;
        }

        if (root.right != null) {
            map.put(root.right, root);
            TreeNode right = findNode(root.right, k, map);
            if (right != null) return right;
        }

        return null;
    }
}
