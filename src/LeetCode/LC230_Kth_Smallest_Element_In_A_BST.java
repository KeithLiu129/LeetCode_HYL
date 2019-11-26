package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

public class LC230_Kth_Smallest_Element_In_A_BST{
    public int kthSmallest(TreeNode root, int k){
        if (root == null) return root.val;
        ArrayList<Integer> nums = inorder(root, new ArrayList<>());
        return nums.get(k - 1);
    }
    private ArrayList<Integer> inorder(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }
}
