import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Heap {

    private int[] elem;
    private int size;

    public Heap(int[] array) {
        this.elem = array;
        this.size = array.length;
    }

    public void CreateHeap() {
        for (int i = (elem.length - 2) / 2; i >= 0; i--) {
            shiftDown(elem, i);
        }

    }

    public void shiftDown(int parent) {
        int child = 2 * parent + 1;

        while (child < size) {
            if (child + 1 < size && elem[child + 1] < elem[child]) {
                child = child + 1;
            }
            if (elem[parent] < elem[child]) {
                break;
            }
            int temp = elem[parent];
            elem[parent] = elem[child];
            elem[child] = temp;

            parent = child;
            child = parent * 2 + 1;
        }
    }

    //小根堆
    public void shiftUp(int child) {
        //child 是第一个节点,不需要调整
        if (child == 0) {
            return;
        }
        int parent = (child - 1) / 2;

        while (child > 0) {
            if (elem[parent] < elem[child]) {
                break;
            } else {
                int temp = elem[parent];
                elem[parent] = elem[child];
                elem[child] = temp;
                // 小的元素向下移动，可能以parent为孩子的子树不满足堆的性质，因此需要继续向上调整
                child = parent;
                parent = (child - 1) / 2;
            }
        }
    }


    public static void main(String[] args) {
        int[] array = {10, 91, 48, 56, 23, 41};
        Heap heap = new Heap(array);
        heap.CreateHeap();
        System.out.println(Arrays.toString(array));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
    }
}
