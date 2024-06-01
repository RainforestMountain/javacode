import org.w3c.dom.ls.LSInput;

import java.util.HashSet;
import java.util.List;

public class Test2 {
    /**
     * Definition for singly-linked list.
     */


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static ListNode reverseList(ListNode head) {
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        ListNode cur = head;
        cur.next = null;
        while (fast != null) {
            slow.next = cur;
            cur = slow;
            slow = fast;
            fast = fast.next;
        }
        slow.next = cur;
        return slow;
    }

    public static ListNode creatList(int... value) {
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int j : value) {
            ListNode p = new ListNode(j);
            cur.next = p;
            cur = p;
        }
        return head.next;
    }


//    public static void main(String[] args) {
//
////        ListNode H = creatList(1, 2, 3, 4, 5, 6);
////        H = reverseList(H);
////        System.out.println();
//
////        ListNode L1 = creatList(1, 2, 4);
////        ListNode L2 = creatList(1, 3, 4);
////        L2 = mergeTwoLists(L1, L2);
//
//        ListNode L = creatList(11, 2, 8, 7, 4);
//        int x = 5;
//        L = partition(L, 5);
//
//    }

    public ListNode middleNode(ListNode head) {
        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            cur = cur.next;
            length++;
        }
        cur = head;
        for (int i = 0; i < length / 2; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode L = new ListNode();
        L.next = list2;
        ListNode left = list1;
        ListNode right = L;
        while (left != null && right.next != null) {
            if (left.val < right.next.val) {
                //用next存储left后面的链表避免丢失
                ListNode next = left.next;
                left.next = right.next;
                right.next = left;
                left = next;
            } else {
                right = right.next;
            }
        }

        if (right.next == null) {
            right.next = left;
        }
        return L.next;
    }

    public static ListNode partition(ListNode pHead, int x) {
        // write code here
        ListNode head = new ListNode(-1);
        ListNode answer = new ListNode(-1);
        head.next = pHead;
        ListNode cur = head;
        ListNode ptr = answer;
        while (cur.next != null) {
            if (cur.next.val < x) {
                ptr.next = cur.next;
                cur.next = cur.next.next;
                ptr = ptr.next;
                ptr.next = null;
            } else {
                cur = cur.next;
            }
        }
        ptr.next = head.next;
        return answer.next;

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        for (int i = 0; i < lists.length; i += 2) {

        }
        return null;
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n <= 0) {
            return null;
        }
        ListNode pHead = new ListNode();
        pHead.next = head;
        ListNode fast = head;
        ListNode slow = pHead;
        int count = n - 1;
        while (count > 0) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            count--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return pHead.next;
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (k < 0 || head == null) {
            return null;
        }
        if (k == 0) {
            return head;
        }
        int len = 1;
        ListNode cur = head;
        while (cur.next != null) {
            len++;
            cur = cur.next;
        }
        cur.next = head;
        int num = len - k % len;
        cur = head;
        for (int i = 0; i < num - 1; i++) {
            cur = cur.next;
        }
        head = cur.next;
        cur.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = creatList(1, 2, 3, 4, 5);
        head = removeNthFromEnd(head, 2);
    }

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

}
