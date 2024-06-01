package test3;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(scanner.nextDouble(), scanner.nextDouble());
        }
        Arrays.sort(points);
        Solution solution = new Solution();
        System.out.println(solution.closestUtil(points, 0, points.length - 1));

    }

    public double bruteForce(Point[] points, int start, int end) {
        double minDist = Double.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            for (int j = i + 1; j <= end; j++) {
                minDist = Math.min(minDist, Math.sqrt(Math.pow(points[i].x - points[j].x, 2)
                        + Math.pow(points[i].y - points[j].y, 2)));
            }
        }

        return minDist;
    }

    /**
     * 主要的递归函数，通过分治法找到最近的两点距离。
     * 首先，将点按照 x 坐标排序。
     * 找到中间点，分别递归计算左右两部分的最近距离。
     * 然后，在中间线附近找到可能更小的距离。从起始start到end不断遍历找到距离中心点Mid最近的点
     * 时间复杂度O(NlogN),分治时间复杂度为O(NlogN),推导是T(n) = 2 * T(n/2) + O(n);Arrays.sort()排序时间复杂度是O(NlogN)
     *
     * @param points
     * @param start
     * @param end
     * @return
     */
    public double closestUtil(Point[] points, int start, int end) {
        if (end - start <= 3) {
            return bruteForce(points, start, end);
        }
        int mid = (start + end) / 2;
        double leftDist = closestUtil(points, start, mid);
        double rightDist = closestUtil(points, mid, end);
        double midDist = Math.min(leftDist, rightDist);

        //越过中间线的两点距离
        // 如果(x - mid.x) ^ 2 < midDist,可能有最小距离
        for (int i = start; i <= end; i++) {
            if (i != mid && Math.pow(points[i].x - points[mid].x, 2) < midDist) {
                midDist = Math.min(Math.sqrt(Math.pow(points[i].x - points[mid].x, 2)
                        + Math.pow(points[i].y - points[mid].y, 2)), midDist);
            }
        }
        return midDist;
    }

}

class Point implements Comparable<Point> {
    double x;
    double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (this.x > o.x) {
            return 1;
        } else if (this.x < o.x) {
            return -1;
        } else {
            return (this.y > o.y ? 1 : -1);
        }
    }
}