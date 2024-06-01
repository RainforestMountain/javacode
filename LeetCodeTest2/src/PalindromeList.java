import org.w3c.dom.Node;

import java.util.HashSet;
import java.util.List;

public class PalindromeList {
    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static boolean chkPalindrome(ListNode head) {
        // write code here
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        ListNode cur = slow;
        slow = slow.next;
        cur.next = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = cur;
            cur = slow;
            slow = next;
        }

        slow = cur;
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    public static ListNode creatList(int... values) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for (int i = 0; i < values.length; i++) {
            ListNode p = new ListNode(values[i]);
            cur.next = p;
            cur = p;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode Node = creatList(1, 2, 3, 2, 1);
        System.out.println(chkPalindrome(Node));

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pa = headA;
        ListNode pb = headB;
        while (true) {
            if (pa == pb) {
                return pa;
            }
            if (pa == null) {
                pa = headB;
            }
            if (pb == null) {
                pb = headA;
            }
            pa = pa.next;
            pb = pb.next;
        }
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static ListNode detectCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (hashSet.contains(cur)) {
                return cur;
            }
            hashSet.add(cur);
            cur = cur.next;
        }
        return null;
    }
}