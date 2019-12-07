package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC366_Find_Leaves_Of_Binary_Tree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        getHeight(root, res);
        return res;
    }

    private int getHeight(TreeNode node, List<List<Integer>> res) {
        if (node == null) return -1;
        int leftHeight = getHeight(node.left, res);
        int rightHeight = getHeight(node.right, res);
        int height = Math.max(leftHeight, rightHeight) + 1;
        if (res.size() > height + 1) res.add(new ArrayList<>());
        res.get(height).add(node.val);
        return height;
    }
}
