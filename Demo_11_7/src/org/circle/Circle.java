package org.circle;

public class Circle {
    public double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {

    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}

class Cylinder extends Circle {
    public double height;

    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }

    public Cylinder() {

    }

    @Override
    public double getArea() {
        return height * getPerimeter() + Math.PI * Math.pow(radius, 2);
    }

    public double getVolume() {
        return height * Math.PI * Math.pow(radius, 2);
    }

}