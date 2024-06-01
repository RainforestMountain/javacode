import java.util.List;

public class MySingleList<T extends Number> {
    static class ListNode<T> {
        T data;
        ListNode<T> next;

        ListNode() {
        }

        ListNode(T data) {
            this.data = data;
        }
    }

    public ListNode<T> head;

    public static void main(String[] args) {
        MySingleList<Integer> mySingleList = new MySingleList<>();
        mySingleList.addLast(5);
        mySingleList.display();
//        mySingleList.addFirst(7);
//        mySingleList.display();
//        mySingleList.addIndex(0, 9);
//        mySingleList.display();
//        mySingleList.remove(7);
//        mySingleList.display();
//        System.out.println(mySingleList.size());
//        System.out.println(mySingleList.contains(9));
//        mySingleList.clear();
//        System.out.println(mySingleList.size());
        mySingleList.remove(5);
        mySingleList.display();

    }

    public void addFirst(T data) {
        ListNode<T> cur = new ListNode<>(data);
        cur.next = this.head;
        this.head = cur;
    }

    //尾插法
    public void addLast(T data) {
        if (this.head == null) {
            this.head = new ListNode<T>(data);
            return;
        }
        ListNode<T> cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new ListNode<T>(data);
    }

    //任意位置插入,第一个数据节点为0号下标
    public boolean addIndex(int index, T data) throws RuntimeException {
        if (index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException("超出索引范围");
        }
        if (index == 0) {
            ListNode<T> cur = new ListNode<>(data);
            cur.next = this.head;
            this.head = cur;
            return true;
        }
        ListNode<T> cur = this.head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        ListNode<T> p = new ListNode<>(data);
        p.next = cur.next;
        cur.next = p;
        return true;
    }


    //查找是否包含关键字key是否在单链表当中
    public boolean contains(T data) {
        ListNode<T> cur = this.head;
        while (cur != null) {
            if (cur.data.equals(data)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //删除第一次出现关键字为key的节点
    public void remove(T data) throws RuntimeException {
        if (this.head == null) {
            throw new NullPointerException("链表为空");
        }
        int index = this.findIndex(data);
        if (index == 0) {
            this.head = this.head.next;
            return;
        }
        ListNode<T> cur = this.head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
    }

    //删除所有值为key的节点
    public void removeAllKey(T data) {
        if (this.head == null) {
            throw new NullPointerException("链表为空");
        }
        ListNode<T> cur = this.head.next;
        ListNode<T> pre = this.head;

        while (cur != null) {
            if (cur.data.equals(data)) {
                pre.next = cur.next;
                cur = pre.next;
            } else {
                cur = cur.next;
                pre = pre.next;
            }
        }
        if (this.head.data.equals(data)) {
            this.head = this.head.next;
        }
    }

    //得到单链表的长度
    public int size() {
        ListNode<T> cur = this.head;
        int size = 0;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

    public void display() {
        ListNode<T> cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public void clear() {
        this.head = null;
    }

    private int findIndex(T data) {
        int index = 0;
        ListNode<T> cur = head;
        while (cur != null) {
            if (cur.data.equals(data)) {
                return index;
            }
            index++;
            cur = cur.next;
        }
        return -1;
    }

}
