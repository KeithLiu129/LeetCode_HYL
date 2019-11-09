package LeetCode;

//95. Unique Binary Search Trees II
//https://leetcode.com/problems/unique-binary-search-trees-ii/

import java.util.LinkedList;
import java.util.List;

public class LC95_Unique_Binary_Search_Trees_II {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new LinkedList<TreeNode>();
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        LinkedList<TreeNode> res = new LinkedList<>();
        if (start > end) {
            res.add(null);
            return res;
        }
        if (start == end) {
            TreeNode root = new TreeNode(start);
            res.add(root);
            return res;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTree = helper(start, i - 1);
            List<TreeNode> rightTree = helper(i + 1, end);

            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }
        return res;
    }
}
