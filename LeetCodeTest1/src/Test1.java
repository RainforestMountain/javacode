public class Test1 {
    /**
     * Definition for singly-linked list.
     * *
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

    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = new ListNode();
        cur.next = head;
        ListNode fast = head;
        ListNode slow = cur;
        while (fast != null) {
            if (fast.val == val) {
                slow.next = fast.next;
                fast = fast.next;
            } else {
                fast = fast.next;
                slow = slow.next;
            }
        }
        return cur.next;
    }

    public static ListNode creatList(int... value) {
        ListNode head = new ListNode();
        ListNode cur = head;
        for (int i = 0; i < value.length; i++) {
            ListNode p = new ListNode(value[i]);
            cur.next = p;
            cur = p;
        }
        return head.next;
    }

    public static void main(String[] args) {

        ListNode H = Test1.creatList(1, 2, 6, 3, 4, 5, 6);
        new Test1().removeElements(H, 6);

        System.out.println();


    }
}
