package test1;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long k = scanner.nextLong();
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextLong();
        }

        Arrays.sort(array);
        int left = 0;
        int right = 0;
        int len = 1;
        for (; right < n; right++) {
            while (left <= right && array[right] - array[left] > k ) {
                len = Math.max(len, right - left);
                left++;
            }
        }
        System.out.println(len);
    }
}
