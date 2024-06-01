package org.test;

public class WildDuck extends Animal implements Flyable, Swimmable {
    @Override
    public void eat() {
        System.out.println("duck eats plants");
    }

    @Override
    public void fly() {
        System.out.println("duck can not fly the sky.");
    }

    @Override
    public void Swim() {
        System.out.println("duck can swim in the lake.");
    }

    public static void main(String[] args) {
        WildDuck w = new WildDuck();
        Swimmable s = w;
        Flyable f = w;
        Animal A = w;

        s.Swim();
        f.fly();
        A.eat();

    }
}
