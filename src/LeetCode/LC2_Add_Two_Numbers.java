package LeetCode;

public class LC2_Add_Two_Numbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummy = new ListNode(0);
        ListNode p = l1, q = l2;
        ListNode prev = dummy;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p == null) ? 0 : p.val;
            int y = (q == null) ? 0 : q.val;
            int sum = x + y + carry;
            carry = sum / 10;
            sum %= sum;
            ListNode cur = new ListNode(sum);
            prev.next = cur;
            prev = cur;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry > 0) {
            prev.next = new ListNode(carry);
        }
        return dummy.next;
    }
}
