import java.sql.SQLOutput;
import java.util.*;

public class Rectangle {
    private double height;
    private double width;

    public Rectangle() {

    }

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Rectangle r = new Rectangle();
        System.out.println("输入高");
        r.setHeight(in.nextDouble());
        System.out.println("输入宽");
        r.setWidth(in.nextDouble());
        System.out.println("height=" + r.getHeight());
        System.out.println("width=" + r.getWidth());
        System.out.println("Parameter=" + r.getParameter());
        System.out.println("Area=" + r.getArea());
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getParameter() {
        return 2 * (height + width);
    }

    public double getArea() {
        return height * width;
    }
}