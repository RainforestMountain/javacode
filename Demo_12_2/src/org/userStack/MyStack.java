package org.userStack;

import java.util.Arrays;

public class MyStack {
    int[] array;
    int size;

    int capacity;

    public MyStack() {
        this.capacity = 10;
        this.array = new int[this.capacity];
    }

    public int push(int data) {
        if (size == capacity) {
            capacity = (int) (capacity * 1.5);
            array = Arrays.copyOf(array, capacity);
        }
        array[size++] = data;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        return array[size];
    }

    public int pop() {
        int data = peek();
        size--;
        return data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
    }
}
