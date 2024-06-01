package org.work3;

public class ElectricVehicle extends Transportation{
    public ElectricVehicle(double distance) {
        super(distance);
    }

    @Override
    public double calculateTime() {
        // 假设电动车的速度为25km/h，开锁和关锁需要20秒
        return distance / 25 + 20.0 / 3600;
    }

    @Override
    public double calculateCost() {
        // 假设电动车的费用为4元/小时
        return calculateTime() * 4;
    }
}
