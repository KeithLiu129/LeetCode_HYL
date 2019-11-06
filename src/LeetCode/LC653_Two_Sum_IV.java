package LeetCode;

//653. Two Sum IV - Input is a BST
//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LC653_Two_Sum_IV {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return findTarget(root, k, set);
    }

    private boolean findTarget(TreeNode root, int k, Set<Integer> set) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return findTarget(root.left, k, set) || findTarget(root.right, k, set);
    }
}
