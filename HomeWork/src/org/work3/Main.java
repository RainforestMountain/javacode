package org.work3;

public class Main {
    public static void main(String[] args) {
        double distance = 2; // 假设距离为2km

        Transportation walking = new Walking(distance);
        System.out.println("步行需要的时间：" + walking.calculateTime() * 60  + "分钟");
        System.out.println("步行需要的费用：" + walking.calculateCost() + "元");

        Transportation bicycle = new Bicycle(distance);
        System.out.println("骑自行车需要的时间：" + bicycle.calculateTime() *60  + "分钟");
        System.out.println("骑自行车需要的费用：" + bicycle.calculateCost() + "元");

        Transportation electricVehicle = new ElectricVehicle(distance);
        System.out.println("电动车需要的时间：" + electricVehicle.calculateTime() * 60 + "分钟");
        System.out.println("电动车需要的费用：" + electricVehicle.calculateCost() + "元");
    }
}
