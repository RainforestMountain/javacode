//import java.util.*;
//
//
//public class Solution {
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     *
//     *
//     * @param str string字符串
//     * @return string字符串
//     */
//    public String setstring (String str) {
//        // write code here
//        StringBuffer answer = new StringBuffer();
//        for(int i = 0; i < str.length(); i++) {
//            if(!answer.toString().contains(String.valueOf(str.charAt(i)))){
//                answer.append(str.charAt(i));
//            }
//        }
//        return answer.toString();
//
//    }
//}

import java.util.*;

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] R = new int[m + n];

        while (i != m || j != n) {
            if (i == m) {
                System.arraycopy(B, j, R, k, n - j);
                j = n;
            }
            if (j == n) {
                System.arraycopy(R, k, A, i, m - i);
                i = n;
            }
            if (A[i] >= B[j]) {
                R[k] = B[j];
                j++;
                k++;
            } else if (A[i] < B[j]) {
                R[k] = A[i];
                i++;
                k++;
            }
        }
        System.arraycopy(R, 0, A, 0, m + n);
    }

    public static void main(String[] args) {

    }
}