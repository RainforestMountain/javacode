import java.util.*;

public class Triangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("输入行数");
        var level = in.nextInt();
        var triangle = new int[level][];
        for (int i = 0; i < triangle.length; i++) {
            triangle[i] = new int[i + 1];
        }
        triangle[0][0] = 1;
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] = 1;
            //每一维数组边缘都是1；除了边缘，其他符合triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            for (int j = 1; j < triangle[i].length - 1; j++) {
                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                triangle[i][triangle[i].length - 1] = 1;
            }
        }
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 1; j < triangle[i].length; j++) {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }
}