import java.util.*;

public class TestDemo1 {
    public static void main(String[] args) {
        var in = new Scanner(System.in);
//        System.out.println("输入一个整数");
//        var n = in.nextInt();
//        if (isPrime(n)) {
//            System.out.println("是素数");
//        } else {
//            System.out.println("不是素数");
//        }
        for (int i = 1; i <= 100; i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
