package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC545_Boundary_Of_Binary_Tree {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        res.add(root.val);
        dfs(root.left, true, false, res);
        dfs(root.right, false, true, res);
        return res;
    }

    private void dfs(TreeNode root, boolean isLeft, boolean isRight, List<Integer> res) {
        if (root == null) return;
        if (isLeft) res.add(root.val);
        if (!isLeft && !isRight && root.left == null && root.right == null) {
            res.add(root.val);
        }
        dfs(root.left, isLeft, isRight && root.right == null, res);
        dfs(root.right, isLeft && root.left == null, isRight, res);
        if (isRight) res.add(root.val);
    }
}

