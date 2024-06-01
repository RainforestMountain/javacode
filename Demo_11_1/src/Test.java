import java.lang.reflect.Field;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = {15, 2, 23, -4};

        System.out.println(my_toString(array));
        //System.out.println(array);
//        Arrays.sort(array);
//        System.out.println(Arrays.toString(array));
//        System.out.println(Arrays.stream(array));

        bubbleSort(array);
        System.out.println(Arrays.toString(array));


    }

    public static String my_toString(int[] array) {
        String ret = "[";
        for (int i = 0; i < array.length; i++) {
            ret += array[i];
            ret += ",";
        }
        ret += "]";
        return ret;
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean exchange = false;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    exchange = true;
                    swap(array, j, j - 1);
                }
            }
            if (exchange == false) {
                return;
            }
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


}

