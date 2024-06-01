package org.circle;

import java.util.Scanner;

public class Task01 {
    public static void main(String[] args) {
        Cylinder cy = new Cylinder();
        Scanner in = new Scanner(System.in);
        System.out.println("输入圆柱半径和高度");
        cy.radius = in.nextDouble();
        cy.height = in.nextDouble();
        System.out.println("表面积 = " + cy.getArea() + " 体积 = " + cy.getVolume());

    }
}
