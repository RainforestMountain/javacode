import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        int[][] array = new int[N][2];//记录巧克力,边长输出一个,所以要同时判断
        int max = 0;
        int left = 1;
        int right = max;
        for (int i = 0; i < N; i++) {
            array[i][0] = in.nextInt();
            array[i][1] = in.nextInt();
            max = Math.max(max, Math.max(array[i][0], array[i][1]));
            left = 1;
            right = max;
        }
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (check(array, mid, K)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(right);
    }


    public static boolean check(int[][] array, int mid, int K) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int wide = Math.min(array[i][0], array[i][1]);
            int height = Math.max(array[i][0], array[i][1]);
            if (mid > wide) {
                continue;
            }
            while (wide >= mid) {
                while (height >= mid) {
                    height = height - mid;
                    count++;
                }
                wide = wide - mid;
                height = Math.max(array[i][0], array[i][1]);
            }
        }
        if (count >= K) {
            return true;
        } else {
            return false;
        }
    }

    //滑动窗口
    public static int lengthOfLongestSubstring(String s) {
        int fast = 0;
        int slow = 0;
        HashSet<Character> set = new HashSet<>();
        int length = 0;
        for (; slow < s.length(); slow++) {
            for (; fast < s.length(); fast++) {
                char ch = s.charAt(fast);
                if (set.contains(ch)) {
                    break;
                } else {
                    set.add(ch);
                }
            }
            length = Math.max(length, set.size());
            set.remove(s.charAt(slow));
        }
        return length;
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(lengthOfLongestSubstring(scanner.nextLine()));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] sum = new int[N];
        for (int i = 0; i < N; i++) {
            int value = scanner.nextInt();
            if (i == 0) {
                sum[0] = value;
            } else {
                sum[i] = sum[i - 1] + value;
            }

        }
        int[] count = new int[K];
        for (int i = 0; i < N; i++) {
            count[sum[i] % K]++;
        }
        int ans = 0;
        for (int i = 0; i < count.length; i++) {
            if (i == 0) {
                ans = ans + (count[i] - 1) * count[i] / 2 + count[i];
            } else {
                ans = ans + (count[i] - 1) * count[i] / 2;
            }
        }
        System.out.println(ans);
    }


}
