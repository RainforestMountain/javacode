package test2;

import java.util.Arrays;

public class Solution {
//    public void duplicate(int[] arr) {
//        int cur = 0;
//        while (cur < arr.length) {
//            if (arr[cur] == 0) {
//                for (int i = arr.length - 1; i >= cur + 1; i--) {
//                    arr[i] = arr[i - 1];
//                }
//                cur += 2;
//            } else {
//                cur++;
//            }
//        }
//
//    }

    public void duplicate(int[] arr) {
        int cur = 0;
        int prev = 0;
        int step = 0;
        int count = 0;
        while (step < arr.length) {
            if (arr[cur] == 0) {
                step += 2;
                count++;
            } else {
                step++;
            }
            cur++;//当Step大于等于length时,cur又多走了一步
        }
        int lastTimes = 1;//最后一个复写元素复写几次,非0都是一次;是0,如果前面的0复写2次只需最后一个复写元素写
        //一次就可以装满数组那么只用复写一次,不然就需要两次
        //cur--;
        if (cur + count == arr.length && arr[cur - 1] == 0) {
            lastTimes = 2;
        }
        for (prev = arr.length - 1, cur--; cur >= 0 && prev >= 0; cur--) {
            if (prev == arr.length - 1) {
                for (int i = 0; i < lastTimes; i++) {
                    arr[prev] = arr[cur];
                    prev--;
                }
            } else {
                if (arr[cur] == 0) {
                    arr[prev] = arr[cur];
                    prev--;
                    arr[prev] = arr[cur];
                    prev--;
                } else {
                    arr[prev] = arr[cur];
                    prev--;
                }
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0};
        solution.duplicate(arr);
        System.out.println(Arrays.toString(arr));
    }
}
