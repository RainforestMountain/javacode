package test4;

import java.util.Arrays;

public class Heap {
    public void sort(int[] array) {
        createHeap(array);
        int size = array.length;
        //把堆顶元素与最后一个元素交换
        while (size > 1) {
            swap(array, 0, size - 1);
            size--;
            shiftDown(array, 0, size);
        }
    }

    public void createHeap(int[] array) {
        //大根堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            shiftUp(array, i);
        }
    }

    public void shiftUp(int[] array, int parent) {
        int child = 2 * parent + 1;
        while (child < array.length) {
            //判断有没有右孩子
            if (child + 1 < array.length && array[child] < array[child + 1]) {
                child = child + 1;
            }
            if (array[parent] > array[child]) {
                break;
            } else {
                swap(array, parent, child);
                parent = child;
                child = 2 * parent + 1;
            }
        }
    }

    //向下调整
    public void shiftDown(int[] array, int parent, int size) {
        int child = 2 * parent + 1;
        while (child < size) {
            if (child + 1 < size && array[child] < array[child + 1]) {
                child = child + 1;
            }
            if (array[parent] > array[child]) {
                break;
            } else {
                swap(array, parent, child);
                parent = child;
                child = 2 * parent + 1;
            }
        }
    }

    public void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        Heap heap = new Heap();
        int[] array = {12, 15, 25, 2, 5, 9, 20, -9, 20};
        heap.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
