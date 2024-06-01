import java.util.List;

public class MyList {
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

    public ListNode head;

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newHead = new ListNode();
        ListNode cur = newHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }
        }
        if (list1 == null) {
            cur.next = list2;
        }
        if (list2 == null) {
            cur.next = list1;
        }
        return newHead.next;
    }

    public void addLast(int data) {
        if (this.head == null) {
            head = new ListNode(data);
            return;
        }
        ListNode cur = head;

        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new ListNode(data);
    }

    public void print() {
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyList list1 = new MyList();
        list1.addLast(14);
        list1.addLast(25);
        list1.addLast(39);
        list1.addLast(54);
        MyList list2 = new MyList();
        list2.addLast(7);
        list2.addLast(28);
        list2.addLast(42);
        list2.addLast(69);
        list1.head = mergeTwoLists(list1.head, list2.head);
        list1.print();
    }
}
