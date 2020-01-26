package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC272_Closest_K_Values {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        //c.c
        Stack<TreeNode> left = new Stack<>();
        Stack<TreeNode> right = new Stack<>();
        List<Integer> res = new ArrayList<>();

        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < target) {
                left.push(cur);
                cur = cur.right;
            }else {
                right.push(cur);
                cur = cur.left;
            }
        }
        for (int i = 0; i < k; i++) {
            if (!left.isEmpty() && !right.isEmpty()) {
                if (Math.abs((double)left.peek().val - target) < Math.abs((double)right.peek().val - target)) {
                    res.add(getNextNode(left, true));
                } else {
                    res.add(getNextNode(right, false));
                }
            } else if (!left.isEmpty()) {
                res.add(getNextNode(left, true));
            } else if (!right.isEmpty()) {
                res.add(getNextNode(right, false));
            }
        }

        return res;
    }

    private int getNextNode(Stack<TreeNode> stack, boolean isLeft) {
        TreeNode top = stack.pop();
        int res = top.val;
        if (isLeft) {
            TreeNode cur = top.left;
            while(cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
        }else {
            TreeNode cur = top.right;
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
        }

        return res;
    }
}
