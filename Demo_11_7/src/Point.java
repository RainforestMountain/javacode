import java.util.Objects;

public class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() {

    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Class name = " + this.getClass() + " x = " + getX() + " y = " + getY();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            return this.x == this.y;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static void main(String[] args) {
        Point p = new Point(2, 2);
        System.out.println(p.toString());
        System.out.println(new Point().equals(p));
        System.out.println(p.hashCode());
    }
}
