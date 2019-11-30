package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LC297_Serialize_And_Deserialize_Binary_Tree {
    public String serialize(TreeNode root) {
        /* StringBuilder sb = new StringBuilder();
        if (root == null) return "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size =0;
            while (size-- > 0) {
                TreeNode cur = queue.poll();
                if (cur != null) sb.append(cur.val);
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        TreeNode root = helper(data, 0, data.length() - 1);
        return root;
    }

    private TreeNode helper(String data, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(data.charAt(mid));
        root.left = helper(data, start, mid - 1);
        root.right = helper(data, mid + 1, end);
        return root;
        */

    }
}
