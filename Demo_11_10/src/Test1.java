import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6};
        transform(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void transform(int[] array) {
        int i = 0;
        int j = array.length - 1;

        while (i < j) {
            while (array[i] % 2 != 0 && i < j) {
                i++;
            }
            while (array[j] % 2 == 0 && i < j) {
                j--;
            }
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }
}
