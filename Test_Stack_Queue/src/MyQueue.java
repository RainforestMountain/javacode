import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
    // 双向链表节点
    public static class ListNode {
        ListNode next;
        ListNode prev;
        int value;

        ListNode(int value) {
            this.value = value;
        }
    }

    ListNode first; // 队头
    ListNode last; // 队尾
    int size = 0;

    // 入队列---向双向链表位置插入新节点
    public void offer(int e) {
        ListNode newNode = new ListNode(e);
        if (first == null) {
            first = newNode;
            // last = newNode;
        } else {
            last.next = newNode;
            newNode.prev = last;
            // last = newNode;
        }
        last = newNode;

        size++;
    }

    // 出队列---将双向链表第一个节点删除掉
    public int poll() {
        // 1. 队列为空
        // 2. 队列中只有一个元素----链表中只有一个节点---直接删除
        // 3. 队列中有多个元素---链表中有多个节点----将第一个节点删除
        int value = 0;
        if (first == null) {
            return -1;
        } else if (first == last) {
            last = null;
            first = null;
        } else {
            value = first.value;
            first = first.next;
            first.prev.next = null;
            first.prev = null;
        }
        --size;
        return value;
    }

    // 获取队头元素---获取链表中第一个节点的值域
    public int peek() {
        if (first == null) {
            return -1;
        }
        return first.value;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);
        q.offer(5); // 从队尾入队列
        System.out.println(q.size());
        System.out.println(q.peek()); // 获取队头元素
        q.poll();
        System.out.println(q.poll()); // 从队头出队列，并将删除的元素返回
        if (q.isEmpty()) {
            System.out.println("队列空");
        } else {
            System.out.println(q.size());
        }
    }
}
