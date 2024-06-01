public class TestDemo3 {

    public static boolean judgeArray(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            if (isOdd(arr[i]) + isOdd(arr[i + 1]) + isOdd(arr[i + 2]) == 3) {
                return true;
            }
        }
        return false;
    }

    public static int isOdd(int i) {
        if (i % 2 == 0) {
            return 0;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 34, 3, 4, 5, 7, 23, 12};
        System.out.println(judgeArray(arr));
    }
}
