import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public static void main(String[] args) {
        int[] arr = new int[]{-5, 9, 1, 2, 5, 25, -6, 10, 5, -7};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int begin, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(begin);
        queue.offer(end);

        while (!queue.isEmpty()) {
            int left = queue.poll();
            int right = queue.poll();
            int div = partition(arr, left, right);

            if (div - left >= 1) {
                queue.offer(left);
                queue.offer(div);
            }
            if (right - (div + 1) >= 1) {
                queue.offer(div + 1);
                queue.offer(right);
            }
        }
    }

    //划分函数
    public static int partition(int[] arr, int left, int right) {
        //挖坑法
        int temp = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= temp) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= temp) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        return left;
    }
}
