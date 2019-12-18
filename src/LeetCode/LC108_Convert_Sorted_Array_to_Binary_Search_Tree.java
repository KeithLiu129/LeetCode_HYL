package LeetCode;

public class LC108_Convert_Sorted_Array_to_Binary_Search_Tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right){
        if (nums == null || nums.length == 0) return null;
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode L = sortedArrayToBST(nums, left, mid - 1);
        TreeNode R = sortedArrayToBST(nums, mid + 1, right);
        if (L != null) root.left = L;
        if (R != null) root.right = R;
        return root;
    }
}
