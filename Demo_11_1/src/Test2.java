import java.util.Arrays;

public class Test2 {
    public static void transform(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 2;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Before: " + Arrays.toString(arr));
        transform(arr);
        System.out.println("After: " + Arrays.toString(arr));
    }
}
