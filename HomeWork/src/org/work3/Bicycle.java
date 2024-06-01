package org.work3;

public class Bicycle extends Transportation {
    public Bicycle(double distance) {
        super(distance);
    }

    @Override
    public double calculateTime() {
        // 假设骑自行车的速度为15km/h，开锁和关锁需要20秒
        return distance / 15 + 20.0 / 3600;
    }

    @Override
    public double calculateCost() {
        // 假设骑自行车的费用为1元/小时
        return calculateTime() * 1;
    }
}
