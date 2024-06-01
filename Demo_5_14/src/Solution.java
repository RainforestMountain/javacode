import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        //编写程序，输入一个大于 2 的自然数，然后输出小于该数字的所有素数组成的列表。
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> result = new LinkedList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                result.add(i);
            }
        }
        System.out.println(result);
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
