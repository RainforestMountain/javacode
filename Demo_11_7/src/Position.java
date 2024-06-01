import java.util.Scanner;

public class Position implements Comparable<Position> {
    public double x;
    public double y;

    public Position(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Position o) {
        if (this.computeDistance(0, 0) > o.computeDistance(0, 0)) {
            return 1;
        } else if (this.computeDistance(0, 0) == o.computeDistance(0, 0)) {
            return 0;
        } else {
            return -1;
        }
    }

    public double computeDistance(double x, double y) {
        return Math.sqrt(Math.pow((this.x - x), 2) + Math.pow((this.y - y), 2));
    }

    public static void main(String[] args) {
        System.out.println("输入p1,p2的坐标");
        Scanner in = new Scanner(System.in);
        Position p1 = new Position(in.nextDouble(), in.nextDouble());
        Position p2 = new Position(in.nextDouble(), in.nextDouble());

        if (p1.compareTo(p2) == 1) {
            System.out.println("p1 > p2 ");
        } else if (p1.compareTo(p2) == 0) {
            System.out.println("p1 == p2 ");
        } else {
            System.out.println("p1 < p2 ");
        }
    }
}
