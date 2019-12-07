package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LC297_Serialize_And_Deserialize_Binary_Tree {
    public String serialize(TreeNode root) {
        if (root == null) return new String();
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur == null) {
                sb.append("#");
            } else {
                sb.append(cur.val);
                q.offer(cur.left);
                q.offer(cur.right);
            }
            sb.append(",");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();

    }


    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        String[] arr = data.split(",");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        q.offer(root);
        for (int i = 1; i < arr.length; i++) {
            TreeNode parent = q.poll();
            if (!arr[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(arr[i]));
                parent.left = left;
                q.offer(left);
            }
            if (!arr[++i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(arr[i]));
                parent.right = right;
                q.offer(right);
            }
        }
        return root;
    }
}
