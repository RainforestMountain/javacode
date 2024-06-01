import java.util.Scanner;

/**
 * 单链表节点
 *
 * @param <T>
 */
class Node<T> {
    public T data;
    public Node<T> next;

    public Node() {
    }

    public Node(T data) {
        this.data = data;
    }

//    public static void PrintNode(Node<Integer> node, Integer data) {
//        while (node != null) {
//            System.out.print(node.data + " ");
//            node = node.next;
//        }
//        System.out.println();
//    }

    public static <T> void PrintNode(Node<T> node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    //显示类名
    public void showType() {
        System.out.println("T的类型是" + data.getClass().getName());
    }

    /**
     * insert方法
     *
     * @param data
     */
    public void insert(T data) {
        Node<T> cur = this;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node<T>(data);

    }
    /*public void insert(T data) {
        this.next = new Node<T>(data);
        this=this.next;
    }*/
}

public class Test {
    public static void main(String[] args) {
//        Node<Integer> Head = new Node<Integer>(10);
//        Head.insert(36);
//        Head.insert(20);
//        Head.insert(40);
//        Node.PrintNode(Head);
//        System.out.println(Head.data);

        short a = 128;
        byte b = (byte) a;
        System.out.println(b);
        System.out.println(a);

        int a1 = 3;
        //需要强转
        //byte b1 = a1;
        long a2 = 12345789;
        float b1 = a2;
        System.out.println(b1);
    }


}

