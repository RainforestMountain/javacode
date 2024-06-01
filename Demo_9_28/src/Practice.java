import java.util.Scanner;
import java.util.Arrays;

public class Practice {


    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        scanner.close();
//
//        //write your code here......
//        System.out.print((a + b) + " " + Math.abs((a - b)) + " ");
//        if (a > b) {
//            System.out.print((a * b) + " " + (a / b) + " " + (a % b));
//        } else {
//            System.out.print((b * a) + " " + (b / a) + " " + (b % a));
//        Scanner scanner = new Scanner(System.in);
//        double d = scanner.nextDouble();
//
//        //write your code here......
//        d = d + 0.5;
//        int n = (int) d;
//        System.out.println(n);
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//
//        //write your code here.......
//        a = a ^ b;
//        b = a ^ b;
//        a = a ^ b;
//        System.out.println(a + " " + b);

//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNextInt()) {
//            int x = scanner.nextInt();
//            int y = scanner.nextInt();
//            Data data = new Data(x, y);
//            System.out.println(data.getX() + data.getY());
//        }
//        int[] ary = new int[6];
//        int max;
//        int min;
//        Scanner scanner = new Scanner(System.in);
//        for (int i = 0; i < ary.length; i++) {
//            ary[i] = scanner.nextInt();
//        }
//
//        //write your code here......
//        Arrays.sort(ary);
//        max = ary[ary.length - 1];
//        min = ary[0];
//
//        System.out.println(max + " " + min);
//        int[][] arr = {{11, 33, 55}, {22, 44, 66, 88}, {131, 214, 315, 146}, {928, 827, 726, 625}, {424, 525}};
//        int sum = add(arr);
//        System.out.println(sum);
//    }
//
//    public static int add(int[][] arr) {
//        int sum = 0;
//
//        //write your code here......
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[i].length; j++) {
//                sum = sum + arr[i][j];
//            }
//        }
//
//        return sum;
//    }
        int[] arr = new int[6];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(arr));

        //write your code here......
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

        System.out.println(Arrays.toString(arr));
    }
}

//class Data {
//
//    private int x;
//    private int y;
//
//    public Data(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//
//    public int getX() {
//        return x;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//}