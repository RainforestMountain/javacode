
class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}

public class Solution2 {
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        head1 = reverse(head1);
        head2 = reverse(head2);
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        ListNode ans = new ListNode(-1);
        ListNode cur = ans;
        int c = 0;//进位,用来处理进位和本位和
        while(cur1 != null || cur2 != null || c != 0) {
            if (cur1 != null) {
                c += cur1.val;
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                c += cur2.val;
                cur2 = cur2.next;
            }
            ListNode temp = new ListNode(c % 10);
            //System.out.println(temp.val);
            cur.next = temp;
            cur = cur.next;
            c = c / 10;
        }
        //结果链表也是反的,需要再次反转
        ans = reverse(ans.next);
        return ans;
    }
    //反转链表
    public ListNode reverse(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode cur = head;
        ListNode next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = newHead.next;
            newHead.next = cur;
            cur = next;
        }
        return newHead.next;
    }
}
