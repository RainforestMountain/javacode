package org.Collection.Deque;
import java.util.*;

public class DequeDemo {
    public static void main(String[] args) {
        Deque<Integer> queue = new ArrayDeque<>();
        Integer[] elements = new Integer[]{1, 2, 3, 0, 7, 8, 9};
        System.out.println(queue.pollLast());
        //removeFirst在队列为空删除抛出NoSuchElementException异常
        try {
            queue.removeFirst();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            System.out.println("删除失败，队列为空");
        }
        queue.addFirst(5);
        for (int i = 0; i < 3; i++) {
            queue.addFirst(elements[i]);
        }
        System.out.println(queue);
        System.out.println();
        for (int i = 4; i < elements.length; i++) {
            queue.offerFirst(elements[i]);
        }
        System.out.println(queue);

        for (int i = 0; i < 2; i++) {
            queue.pollLast();
        }
        System.out.println(queue);
        //使用迭代器
        for (Iterator<Integer> iter = queue.iterator(); iter.hasNext(); ) {
            System.out.print(iter.next() + " ");
        }
        System.out.println();
        queue.clear();
        System.out.println(queue);
        //添加所有元素
        queue.addAll(List.of(elements));
        System.out.println(queue);
    }
}
