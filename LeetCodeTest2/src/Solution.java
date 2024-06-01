import java.util.Arrays;
import java.util.List;

public class Solution {
    //    public int missingNumber(int[] nums) {
//        int[] counts = new int[nums.length + 1];
//        for (int i = 0; i < nums.length; i++) {
//            counts[nums[i]]++;
//        }
//        for (int i = 0; i < counts.length; i++) {
//            if (counts[i] == 0) {
//                return i;
//            }
//        }
//        return -1;
//    }
    public static void rotate(int[] nums, int k) {

//        ListNode head = creatList(nums);
//        ListNode cur = head;
//        while (cur.next != null) {
//            cur = cur.next;
//        }
//        cur.next = head;
//        k = nums.length - k % nums.length;
//        for (int i = 0; i < k; i++) {
//            head = head.next;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = head.val;
//            head = head.next;
//        }

    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
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
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);

    }
}
