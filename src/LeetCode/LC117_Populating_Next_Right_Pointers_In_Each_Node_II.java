package LeetCode;

public class LC117_Populating_Next_Right_Pointers_In_Each_Node_II {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null) return root;
        Node cur = root;
        Node prev = null;
        Node head = null;

        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    if (prev == null) {
                        head = cur.left;
                    }else {
                        prev.next = cur.left;
                    }
                    prev = cur.left;
                }
                if (cur.right != null) {
                    if (prev == null) {
                        head = cur.right;
                    }else {
                        prev.next = cur.right;
                    }
                    prev = cur.right;
                }
                cur = cur.next;
            }
            cur = head;
            head = null;
            prev = null;
        }

        return root;
    }
}
