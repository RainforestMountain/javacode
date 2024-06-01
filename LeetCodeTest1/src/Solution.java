import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> hashSet = new HashSet<>();
        while (headA != null) {
            hashSet.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (hashSet.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode L1 = creatList(4, 1);
        ListNode L2 = creatList(5, 6, 1);
        ListNode node1 = new ListNode(8);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        L1.next.next = node1;
        L2.next.next.next = node1;

        ListNode L = getIntersectionNode(L1, L2);
    }

    public static ListNode creatList(int... value) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for (int j : value) {
            ListNode p = new ListNode(j);
            cur.next = p;
            cur = p;
        }
        return head.next;
    }

    public static boolean chkPalindrome(ListNode A) {
        // write code here
        if (A == null || A.next == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode cur = A;
        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }

        while (A != null) {
            if (A.val != stack.pop()) {
                return false;
            }
            A = A.next;
        }
        return true;


    }

    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode FindKthToTail(ListNode head, int k) {
        if (k < 0) {
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (k > stack.size()) {
            return null;
        }
        ListNode ans = new ListNode(0);
        for (int i = 0; i < k; i++) {
            if (stack.isEmpty()) {
                return null;
            }
            ans = stack.pop();
        }

        return ans;
    }
}