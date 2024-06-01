public class TestDemo1 {
    public static void main(String[] args) {
        int[] arr = {2, 9, 2, 4, 4, 6, 6, 7, 7};
        System.out.println(singleElement(arr));
    }

    public static int singleElement(int[] arr) {
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            n = n ^ arr[i];
        }
        return n;
    }
}
