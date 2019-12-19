package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC513_Find_Bottom_Left_Tree_Value {
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) throw new IllegalArgumentException();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            root = q.poll();
            if (root.left != null) q.offer(root.left);
            if (root.right != null) q.offer(root.right);
            }

        return root.val;
    }
}
