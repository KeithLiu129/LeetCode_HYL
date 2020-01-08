package LeetCode;

public class LC237_Delete_Node_in_A_Linked_List {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
