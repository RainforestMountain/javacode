package org.Collection.Deque.LinkedList;

import java.util.Iterator;
import java.util.LinkedList;

public class LinKedListDemo {
    public static void main(String[] args) {
        int time = 10;
        LinkedList<Object> queue = new LinkedList<>();
        for (int i = time; i > 0; i--) {
            queue.addFirst(i);
        }
        for (Iterator<Object> iter = queue.iterator(); iter.hasNext(); ) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
        while (!queue.isEmpty()) {
            System.out.print(queue.removeLast() + " ");
            try {
                Thread.currentThread().sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace(System.out);
            }
//            finally {
//                System.out.println(Thread.currentThread().isInterrupted());
//            }
        }
        // Thread.currentThread().start();
        System.out.println();

    }
}
