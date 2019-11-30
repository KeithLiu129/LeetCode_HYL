package LeetCode;

public class LC99_Recover_Binary_Search_Tree {
    TreeNode pre = null;
    public void recoverTree(TreeNode root) {
        TreeNode[] mistake = new TreeNode[2];
        dfs(root, mistake);
        int x = mistake[0].val;
        int y = mistake[1].val;
        mistake[0].val = y;
        mistake[1].val = x;

    }

    private void dfs(TreeNode cur, TreeNode[] mistake) {
        if (cur == null) return;
        //in-order
        dfs(cur.left, mistake);
        if (pre != null && pre.val  > cur.val) {
            mistake[1] = cur;
            if (mistake[0] == null) {
                mistake[0] = pre;
            }
        }
        pre = cur;
        dfs(cur.right, mistake);
    }
}
