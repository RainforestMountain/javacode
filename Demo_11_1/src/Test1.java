import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if (i % 9 == 0 && i != 0) {
                System.out.println();
            }
        }
    }
}
