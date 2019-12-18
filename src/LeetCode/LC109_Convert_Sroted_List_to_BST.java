package LeetCode;

public class LC109_Convert_Sroted_List_to_BST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    ListNode cur = null;
    public TreeNode sortedListToBST(ListNode head) {
        cur = head;
        int len = getLen(head);
        return helper(0, len - 1);
    }

    private TreeNode helper(int l, int r) {
        if (l > r) return null;
        int mid = (l + r) / 2;
        TreeNode left = helper(l, mid - 1);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode right = helper(mid + 1, r);
        root.left = left;
        root.right = right;
        return root;
    }

    private int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
