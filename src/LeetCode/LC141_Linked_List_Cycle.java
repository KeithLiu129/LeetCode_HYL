package LeetCode;

public class LC141_Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != null && slow.next != null) {
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
