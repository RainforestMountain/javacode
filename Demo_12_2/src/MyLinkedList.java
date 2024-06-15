public class MyLinkedList {

    static class ListNode {
        public int val;
        public ListNode next;
        public ListNode prev;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode head;
    public ListNode last;

    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (head == null) {
            head = node;
            last = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (last == null) {
            last = node;
            head = node;
        } else {
            last.next = node;
            node.prev = last;
            last = node;
        }

    }

    public static void main(String[] args) {
        int temp = 0;
        System.out.println(temp);

    }
}