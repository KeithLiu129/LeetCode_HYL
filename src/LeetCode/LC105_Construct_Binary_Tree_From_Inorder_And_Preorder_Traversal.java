package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LC105_Construct_Binary_Tree_From_Inorder_And_Preorder_Traversal {
    public TreeNode buildTree(int[] inorder, int[] preorder) {
        if (inorder == null || preorder == null || inorder.length == 0|| inorder.length != preorder.length) return null;
        //Hashmap optimization
        Map<Integer, Integer> map = new HashMap<>();
        for (int i= 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, preorder, 0, preorder.length - 1, 0, inorder.length -1, map);
    }

    private TreeNode buildTree(int[] inorder, int[] preorder, int p_start, int p_end, int i_start, int i_end, Map<Integer,Integer> map) {
        if (p_start > p_end) return null;
        TreeNode root = new TreeNode(preorder[p_start]);
        /*
        int idx = i_start;

        for (; idx < i_end; idx++) {
            if (inorder[idx] == root.val) {
                 break;
            }
        }
        */
        int idx = map.get(root.val);

        int leftNum = idx - i_start;


        root.left = buildTree(inorder, preorder, p_start + 1, p_start + leftNum  , i_start, idx - 1, map);
        root.right = buildTree(inorder, preorder, p_start + leftNum + 1, p_end, idx + 1, i_end, map);
        return root;
    }
}
