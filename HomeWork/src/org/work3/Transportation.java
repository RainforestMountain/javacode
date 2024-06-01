package org.work3;

public abstract class Transportation {
    protected double distance;
    protected double time;

    public Transportation(double distance) {
        this.distance = distance;
    }

    public abstract double calculateTime();

    public abstract double calculateCost();
}
