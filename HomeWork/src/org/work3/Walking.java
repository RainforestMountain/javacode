package org.work3;

public class Walking extends Transportation {
    public Walking(double distance) {
        super(distance);
    }

    @Override
    public double calculateTime() {
        // 假设步行速度为5km/h
        return distance / 5;
    }

    @Override
    public double calculateCost() {
        // 步行不需要花费金钱
        return 0;
    }
}
