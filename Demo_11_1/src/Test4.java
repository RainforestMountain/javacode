import java.util.Arrays;

public class Test4 {
    public static void main(String[] args) {
        int[] arr = {12, 85, 93, 0, 36, 15};
        adjustArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void adjustArray(int[] arr) {
        int[] temp = new int[arr.length];
        for (int i = 0, j = 0, k = arr.length - 1; i < arr.length && j < arr.length && k >= 0; i++) {
            if (arr[i] % 2 != 0) {
                temp[j] = arr[i];
                j++;
            } else {
                temp[k] = arr[i];
                k--;
            }
        }
        System.arraycopy(temp, 0, arr, 0, arr.length);
    }
}
