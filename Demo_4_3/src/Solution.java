import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void countSort(int[] arr) {
        int[] count = new int[10];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }
        int k = 0;
        for (int i = 0; i < count.length; i++) {
            int temp = count[i];
            while (temp > 0) {
                arr[k] = i;
                k++;
                temp--;
            }
        }
    }

    public static int averageCost() {

        int[] count = new int[10];
        int[] max = new int[10];
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //将key相同的value相加,找到最大成本,减去就是最小开销
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            count[a] = count[a] + b;
            if (b > max[a]) {
                max[a] = b;
            }
        }
        int sum = 0;
        for (int i = 0; i < count.length; i++) {
            sum = sum + count[i] - max[i];
        }
        return sum;
    }

//    public static void main(String[] args) {
//        int[] arr = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4};
//        countSort(arr);
//        //System.out.println(Arrays.toString(arr));
//        //System.out.println(averageCost());
//        int[][] array = board();
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[i].length; j++) {
//                System.out.print(array[i][j]);
//            }
//            System.out.println();
//        }
//
//    }

    public static int[][] board() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] array = new int[n][n];
        for (int i = 0; i < m; i++) {
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            for (int j = x1; j <= x2; j++) {
                for (int k = y1; k <= y2; k++) {
                    if (array[j - 1][k - 1] == 1) {
                        array[j - 1][k - 1] = 0;
                    } else {
                        array[j - 1][k - 1] = 1;
                    }
                }
            }
        }

        return array;
    }

    public static long commonFactor(long a, long b) {
        long r = a % b;
        while (r != 0) {
            a = b;
            b = r;
            r = a % b;
        }
        return b;
    }

    public static int relativePrime(int a, int b) {
        long n = (long) Math.pow(a, b);
        int count = 0;
        for (long i = 1; i < n; i++) {
            long r = commonFactor(i, a);
            if (r == 1) {
                count++;
            }
        }
        return count;
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        int b = scanner.nextInt();
//        System.out.println(relativePrime(a, b));
//    }

    public static int func(int n) {
        int ret = 1;
        for (int i = 2; i <= n; i++) {
            ret = ret * i;
        }
        return ret;
    }

    public static int maxFactor() {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            sum = sum + func(a);
        }
        int m = 1;
        for (; m <= sum / 2; m++) {
            int temp = func(m);
            if (sum % temp != 0) {
                break;
            }
        }
        return m - 1;
    }

    public static void main(String[] args) {
        System.out.println(maxFactor());
    }

    
}
