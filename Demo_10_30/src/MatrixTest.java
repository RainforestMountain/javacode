import com.sun.security.jgss.GSSUtil;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        var A = new int[n][n];
        int k = 1;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                A[i][j] = k;
                k++;
            }
        }
        System.out.println("旋转前的数组：");
        for (int i = 0; i < A.length; i++) {
            System.out.println(Arrays.toString(A[i]));
        }
        rightSpin(A);
        System.out.println("旋转后的数组：");
        for (int i = 0; i < A.length; i++) {
            System.out.println(Arrays.toString(A[i]));
        }
    }

    public static void rightSpin(int[][] A) {
        //A.length==A.[i].length
        int[][] B = new int[A.length][A[0].length];
        // System.arraycopy(A, 0, B, 0, A.length);
        for (int i = 0; i < A.length; i++) {
            System.arraycopy(A[i], 0, B[i], 0, A[i].length);
        }
        for (int j = A[0].length - 1; j >= 0; j--) {
            for (int i = 0; i < A.length; i++) {
                A[i][j] = B[A[0].length - 1 - j][i];
            }
        }

    }
}
