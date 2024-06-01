package test4;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int N = 4;

        int[][] array = new int[N][N];
        gameTable(N, array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    public static void gameTable(int k, int[][] array) {
        //处理第一天的每组选手赛程
        for (int i = 0; i < k; i++) {
            array[i][0] = i + 1;
        }
        for (int i = 0; i < k; i++) {
            if (i % 2 == 0) {
                array[i][1] = array[i + 1][0];
            } else {
                array[i][1] = array[i - 1][0];
            }
        }

        int n = 2;
        while (n < k) {
            for (int i = 0; i < k; i++) {
                int area = i / n;
                for (int j = 0; j < n; j++) {
                    if (area % 2 == 0) {
                        array[i][n + j] = array[i + n][j];
                    } else {
                        array[i][n + j] = array[i - n][j];
                    }
                }
            }
            n *= 2;
        }
    }
}
