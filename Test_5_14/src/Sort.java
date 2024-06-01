import java.util.Arrays;

public class Sort {

    // 归并排序---递归
    public static void mergeSort1(int[] array) {
        // write code  here


    }

    // 归并排序---非递归
    public static void mergeSort2(int[] array) {
        // write code  here
    }

    public static void merge(int[] array, int left, int mid, int right) {
        if (right <= left) {
            return;
        }
        int[] L = Arrays.copyOfRange(array, left, mid);
        int[] R = Arrays.copyOfRange(array, mid, right);

        int i = 0;
        int j = 0;
        int k = left;
        while (i < L.length || j < R.length) {
            if (i == L.length) {

            }
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            }
        }
    }

    // 计数排序
    public static void countSort(int[] array) {
        // write code  here
    }
}
